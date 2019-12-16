package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    private ArrayList<Integer>[]  data;
    private boolean[] isvisited;
    private int[] isnoNull;
    private AtomicInteger verticles;
    private Integer nonullvertcounter = 0;
    private String path = "path is: ";


    public DataProcessor(ArrayList<Integer>[]  data) {
        this.data = data;
        this.verticles = new AtomicInteger();
    }

    public Integer prePprocessData(){

        for (int i=0; i<data.length; i++) {
            if (data[i].size() != 0) {
                System.out.print("для вершины " + i + " найдены грани: " + " ");
                nonullvertcounter ++;
                //цикл нужен т.к. мы считаем вершины внутри каждого Листа
                data[i].forEach(item -> {
                    System.out.print(item+", ");
                    verticles.getAndIncrement();
                });
                System.out.print("\n");
            } else {
                System.out.println("для вершины " + i + "грани не найдены:");
            }
        }

        if (verticles.get() < 3){
            System.out.println("Некорректные входные данные, количество домино должно быть 2 и более");
            return null;
        } else {
            System.out.println("общее количество вершин: "+verticles);
            return verticles.get();
        }
    }

    boolean checkIfConnected (Integer vert){
        //создаем массив для регистрации посещеных вершин

        isvisited = new boolean[vert+1];
        isnoNull = new int[nonullvertcounter+1];
        boolean isConnected = true;

        for (int i = 0; i < vert; i++) {
            //помечаем все вершины как не посещенные
            isvisited[i] = false;
        }

        int count = 0;
        for (int i = 0; i<7; i++) {
            if (data[i].size() != 0) {
                //записываем номер ненулевой вершины в массив ненулевых вершин
                isnoNull[count] = i;
                ++count;
            }
        }

        //рекурсивно проверяем все вершины на связь друг с другом, связанные помечаем как true
            recurCounterOfVertex(isnoNull[0], isvisited);
        //
        for (int i=0; i<data.length; i++){
            if (!isvisited[i] && data[i].size()>0){
                System.out.println("найдена изолированная вершина " + i);
                isConnected = false;
            }
        }
        return isConnected;
    }

    private void recurCounterOfVertex(int nnvert, boolean[] isvisited) {
        isvisited[nnvert] = true;
        path = path.concat(String.valueOf(nnvert));
        System.out.println("вершина " + nnvert + " помечена как посещенная");
        // Recur for all the vertices adjacent to this vertex
        for (int n : data[nnvert]) {
            if (!isvisited[n])
                recurCounterOfVertex(n, isvisited);
        }
    }

    public boolean countVertDegree() {
        int oddedges = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].size() % 2 != 0) {
                oddedges++;
                System.out.print("для вершины " + i + " степень граней нечетная " + data[i].size() % 2);
                System.out.println(" общее количество нечетных граней достигло " + oddedges);
            }
        }
        return oddedges <= 2;
    }

    public void printPath(){
        System.out.println(path);
    }
}
