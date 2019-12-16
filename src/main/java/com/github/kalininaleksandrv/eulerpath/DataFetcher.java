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

    public ArrayList<Integer>[]  dataMainRouter(String filePath) {
        return prepareListOfEdges(fetchDataFromFile(filePath));
    }

    public String fetchDataFromFile(String filePath) {

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    private ArrayList<Integer>[] prepareListOfEdges(String result) {

        ArrayList<String> listofedges = new ArrayList<>();

        new ArrayList<>(Arrays.asList(result.split(",")))
                .forEach(i -> listofedges.add(i));

        ArrayList<Integer>[] arrayofedges = new ArrayList[7];
        for (int i=0; i<arrayofedges.length; i++){
            arrayofedges[i] = new ArrayList<>();
        }

        listofedges.stream().map(i -> i.split(":")).forEach(res -> {
                    arrayofedges[Integer.parseInt(res[0])].add(Integer.parseInt(res[1]));
                    arrayofedges[Integer.parseInt(res[1])].add(Integer.parseInt(res[0]));
                });

        return arrayofedges;
    }


}