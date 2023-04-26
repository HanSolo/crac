package eu.hansolo.micronaut;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Constants {
    public static final String DATA_FILENAME = "names.json";

    public static final Random RND           = new Random();

}
