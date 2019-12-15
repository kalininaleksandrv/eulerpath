package main.java.com.github.kalininaleksandrv.eulerpath;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class DataFetcher {

    public DataFetcher() {
    }

    public ArrayList<String> fetchDataFromFile(String filePath){

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String result = contentBuilder.toString();
        System.out.println(result);

        return new ArrayList<>(Arrays.asList(filePath, "one", "two", "three"));
    }
}
