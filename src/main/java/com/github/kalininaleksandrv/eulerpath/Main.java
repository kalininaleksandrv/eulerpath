package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.ArrayList;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        //задача определить возможность создания непрерывной последовательности костяшек домино сводится к задаче "ейлерова пути" в графе
        //Эйлеров цикл существует тогда и только тогда, когда степени всех вершин чётны.
        //Эйлеров путь существует тогда и только тогда, когда количество вершин с нечётными степенями равно двум
        //(или нулю, в случае существования эйлерова цикла).

        //в аргументе передать полный путь к файлу с данными

        getEulerPath(args[0]);
    }

    private static void getEulerPath(String path) {

        boolean isconnected = false;
        DataFetcher dataFetcher = new DataFetcher();
        ArrayList<Integer>[] data = dataFetcher.dataMainRouter(path);

        DataProcessor dataProcessor = new DataProcessor(data);
        Integer vert = dataProcessor.prePprocessData();
        if (vert != null){
             isconnected = dataProcessor.checkIfConnected(vert);
        }

        if(isconnected){
            if (dataProcessor.countVertDegree()){
                System.out.println("есть последовательность для этого набора: ");
                dataProcessor.printPath();
            } else {
                System.out.println("невозможно сложить эти домино в последовательность");
            }
        } else {
            System.out.println("невозможно сложить эти домино в последовательность");
        }

    }

}
