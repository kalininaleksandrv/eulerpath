package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataProcessor {
    private ArrayList<Edge> data;
    private int vertices;

    public DataProcessor(ArrayList<Edge> data) {
        this.data = data;
        this.vertices = data.size()*2;
    }

    public String processData(){

        if (data.size() < 2){
            return "Некорректные входные данные, количество домино должно быть 2 и более";
        }

        System.out.println(vertices);
        data.forEach(i -> System.out.println(i.toString()));
        return "---------------->";
    }
}
