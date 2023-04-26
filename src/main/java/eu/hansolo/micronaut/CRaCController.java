package eu.hansolo.micronaut;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Comparator;
import java.util.List;


@Controller()
public class CRaCController {

    // Call it like this: curl "http://localhost:8080/names?gender=female&amount=10"
    @Get(value = "/names{?gender,amount}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> getNames(@Nullable final String gender, @Nullable final Integer amount) {
        final long       start   = System.nanoTime();

        final Gender     _gender = (null == gender || gender.isEmpty()) ? Constants.RND.nextBoolean() ? Gender.FEMALE : Gender.MALE : Gender.fromText(gender);
        final int        _amount = (null == amount || amount < 1) ? 5 : amount;
        final List<Name> names   = Helper.getRandomNames(_amount, _gender);

        // Sort names
        names.sort(Comparator.comparing(Name::getFirstName));

        // Create Json output
        final StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("{\n")
                  .append("  \"names\":[\n");
        names.forEach(name -> msgBuilder.append("    {\n")
                  .append("      \"").append("first_name").append("\":\"").append(name.getFirstName()).append("\",\n")
                  .append("      \"").append("gender").append("\":\"").append(name.getGender().name().toLowerCase()).append("\"\n")
                  .append("    },\n"));
        msgBuilder.setLength(msgBuilder.length() - 2);
        msgBuilder.append("\n  ],\n")
                  .append("  \"response_time\":\"")
                  .append((System.nanoTime() - start) / 1_000_000)
                  .append(" ms\"\n")
                  .append("}");

        return HttpResponse.ok(msgBuilder.toString()).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
    }
}
