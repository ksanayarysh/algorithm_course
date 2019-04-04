package lesson2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Main {
    static final int TEST_COUNT = 10000;
    static final int ARRAY_SIZE = 100;
    static final int LOW = 200;
    static final int HIGH = 1000;
    FileWriter file;


    // Чистим массив
    private void refreshArray(MyArrayList<Integer> array) {
        Random r = new Random();
        array.clear();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array.add(LOW + r.nextInt (HIGH - LOW));

        }
    }

    // Пишем логи в консоль и в файл
    private void log(FileWriter file, String msg) throws IOException {
        System.out.println(msg);
        file.append(msg + "\r\n");
    }

    // Запускаем сортировку TEST_COUNT раз
    public void sortMyArray(SortType sortType, MyArrayList<Integer> b) throws IOException{
        long time_elapced = 0L;
        for (int i = 0; i < TEST_COUNT; i++) {
            refreshArray(b);
            long start_time = System.nanoTime();
            b.sort(sortType);
            time_elapced += (System.nanoTime() - start_time);
        }

        log(file, "Среднее время на " + sortType.getName() + " " +
                String.format("%.5f ms", (double) (time_elapced / Math.pow(10, 6) / TEST_COUNT)));
    }

    // Запускаем тесты
    public void runTest() throws IOException {
        MyArrayList<Integer> b = new MyArrayList<>();

        file = new FileWriter("results.txt", false);
        log(file, ("Количество элементов в массиве: " + ARRAY_SIZE + "\r\n"));
        log(file, ("Количество тестов: " + TEST_COUNT));

        log(file, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime()));

        sortMyArray(SortType.SELECTION, b);
        sortMyArray(SortType.INSERTION, b);
        sortMyArray(SortType.BUBBLE, b);

        log(file, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime()));

        file.close();

    }

    public static void main(String[] args) throws IOException {
        new Main().runTest();
    }
}


