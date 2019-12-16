package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.max;

public class DataProcessor {
    private final ArrayList<Integer>[] data;
    private final AtomicInteger verticles;
    private Integer nonullvertcounter = 0;
    private final List<Integer[]> edgelist;

    public DataProcessor(ArrayList<Integer>[]  data) {
        this.data = data;
        this.verticles = new AtomicInteger();

        edgelist = new LinkedList<>();
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
                System.out.println("для вершины " + i + " грани не найдены:");
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

        boolean[] isvisited = new boolean[max(data.length, vert)];
        int[] isnoNull = new int[nonullvertcounter];
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

        System.out.println("ненулевые вершины: " + Arrays.toString(isnoNull));

            recurCounterOfVertex(isnoNull[0], isvisited);

        for (int i=0; i<data.length; i++){
            if (!isvisited[i] && data[i].size()>0){
                System.out.println("найдена изолированная вершина " + i);
                isConnected = false;
            }
        }
        return isConnected;
    }

    //рекурсивно проверяем все вершины на связь друг с другом, связанные помечаем как true
    private void recurCounterOfVertex(int nnvert, boolean[] isvisited) {


        isvisited[nnvert] = true;

        for (int n : data[nnvert]) {
            System.out.println("ПОЛНЫЙ ОБХОД идем из " + nnvert + " в " +n);

            collectPairs(nnvert, n);

            //передавать значение нужно когда меняется nnvert
            if (!isvisited[n]) {
                System.out.println("---------");
                recurCounterOfVertex(n, isvisited);
            }

        }

    }

    private void collectPairs(int sourcevert, int targetvert) {
        Integer [] pair = new Integer[2];
        pair[0] = sourcevert;
        pair[1] = targetvert;
        edgelist.add(pair);
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

        int count;
        int prev;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < edgelist.size()-1; i++) {
            prev = edgelist.get(i)[0];
            count = edgelist.get(i+1)[0];
            if(prev != count) {
                sb.append(Arrays.toString(edgelist.get(i))).append(" ");
            }

        }

        System.out.println(sb);
    }
}
