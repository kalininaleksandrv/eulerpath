package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.ArrayList;

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
        DataFetcher dataFetcher = new DataFetcher();
        ArrayList<String> data = dataFetcher.fetchDataFromFile(path);

        data.forEach(item->{
                System.out.println(item);
        });
    }
}
