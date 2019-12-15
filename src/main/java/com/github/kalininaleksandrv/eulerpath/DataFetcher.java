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

    public ArrayList<Edge> dataMainRouter(String filePath) {
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

    private ArrayList<Edge> prepareListOfEdges(String result) {

        ArrayList<Edge> listofedges = new ArrayList<>();

        new ArrayList<>(Arrays.asList(result.split(",")))
                .forEach(i -> {
                    String [] res = i.split(":");
                    Edge myedge = new Edge(Integer.parseInt(res [0]), Integer.parseInt(res [1]));
                    myedge.checkForSymetrical();
                    listofedges.add(myedge);
                });

        return listofedges;
    }


}