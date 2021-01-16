package com.javarush.task.task18.task1820;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            String f1 = sc.nextLine();
            String f2 = sc.nextLine();
            sc.close();

            FileReader fr = new FileReader(f1);
            Scanner sc2 = new Scanner(fr);
            FileWriter writer = new FileWriter(f2);
            sc2.useLocale(Locale.ENGLISH);
            while (sc2.hasNextDouble()){
                int data = (int)Math.round(sc2.nextDouble());
                writer.write(data + " ");
            }
            fr.close();
            sc2.close();
            writer.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

//    Округление чисел
//    Считать с консоли 2 имени файла.
//        Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
//        Округлить числа до целых и записать через пробел во второй файл.
//        Закрыть потоки.
//
//        Принцип округления:
//        3.49 => 3
//        3.50 => 4
//        3.51 => 4
//        -3.49 => -3
//        -3.50 => -3
//        -3.51 => -4
//
//
//        Требования:
//        1. Программа должна два раза считать имена файлов с консоли.
//        2. Для первого файла создай поток для чтения. Для второго - поток для записи.
//        3. Считать числа из первого файла, округлить их и записать через пробел во второй.
//        4. Должны соблюдаться принципы округления, указанные в задании.
//        5. Созданные для файлов потоки должны быть закрыты.