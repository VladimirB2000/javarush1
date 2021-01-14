package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // create scanner for read file name
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        // read first fail
        BufferedReader br = new BufferedReader(new FileReader(file1));
        StringBuilder str = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            str.append(line);
        // stream for write in first file
        FileWriter writer = new FileWriter(file1);
        //read second file
        BufferedReader br2 = new BufferedReader(new FileReader(sc.nextLine()));
        StringBuilder str2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null)
            str2.append(line2);
        // write in first file
        writer.append(str2);
        writer.append(str);

        br.close();
        writer.close();
        br2.close();

    }
}

//    Объединение файлов
//    Считать с консоли 2 имени файла.
//        В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна два раза считать имена файлов с консоли.
//        2. Не используй в программе статические переменные.
//        3. Для первого файла создай поток для чтения и считай его содержимое.
//        4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
//        5. Содержимое первого и второго файла нужно объединить в первом файле.
//        6. Сначала должно идти содержимое второго файла, затем содержимое первого.
//        7. Созданные для файлов потоки должны быть закрыты.
