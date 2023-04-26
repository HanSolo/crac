## CRaC Name service
This is a little demo service, which first loads around 280000 names from a json
file into memory and that has an endpoint that can generate a given amount of  
either female or male first names and returns them in json format.

Start the application with 
```./gradlew run```

Open a browser and type in
```http://localhost:8080/names?gender=female&amount=10```

You should see 10 random female names in JSON format in your browser and also the
time it took to create the response.


### Run without CRaC
Execute ```./gradlew run```

Execute ```curl "localhost:8080/names?gender=female&amount=5"```

The result should show something like this for the first response without CRaC:
```json
{
  "names":[
    {
      "first_name":"Birtha",
      "gender":"female"
    },
    {
      "first_name":"Dorothea",
      "gender":"female"
    },
    {
      "first_name":"Eva",
      "gender":"female"
    },
    {
      "first_name":"Lynnette",
      "gender":"female"
    },
    {
      "first_name":"Missy",
      "gender":"female"
    }
  ],
  "response_time":"931 ms"
}
```

This is for the first response only and you see that the response time in this case was 931 ms.


### Run with CRaC

#### Build docker image
Execute ```./gradlew dockerBuildCrac``` to create a docker image containing a CRaC
enabled JDK and a pre-warmed, checkpointed application.

Execute ```bash start.sh```

Execute ```curl "localhost:8080/names?gender=female&amount=5"```

The result should show something like this for the first response with CRaC:
```json
{
  "names":[
    {
      "first_name":"Berta",
      "gender":"female"
    },
    {
      "first_name":"Doris",
      "gender":"female"
    },
    {
      "first_name":"Emma",
      "gender":"female"
    },
    {
      "first_name":"Lisa",
      "gender":"female"
    },
    {
      "first_name":"Melanie",
      "gender":"female"
    }
  ],
  "response_time":"21 ms"
}
```

This is for the first response only and you see that the response time in this case was 21 ms,
which is way faster because the application was already "warmed up". Here the warm up
is mainly loading the names from the json file into memory.
