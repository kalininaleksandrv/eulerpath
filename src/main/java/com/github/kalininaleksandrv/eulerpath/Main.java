package main.java.com.github.kalininaleksandrv.eulerpath;

public class Main {
    public static void main(String[] args) {
        //задача определить возможность создания непрерывной последовательности костяшек домино сводится к задаче "ейлерова пути" в графе
        //Эйлеров цикл существует тогда и только тогда, когда степени всех вершин чётны.
        //Эйлеров путь существует тогда и только тогда, когда количество вершин с нечётными степенями равно двум
        //(или нулю, в случае существования эйлерова цикла).
        System.out.println("Ейлеров путь "+ getEulerPath());
    }

    private static String getEulerPath() {
        return "существует";
    }
}
