package com.javarush.task.task18.task1828;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String f = sc.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(f));

        List<String> l = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            l.add(line);
            line = reader.readLine();
        } //записали содержиоме файла в список l

        if (args.length == 0) {
            sc.close();
            reader.close();
        } else if (args[0].equals("-d")) {
            //создаем новый список для записи
            StringBuilder stringBuilder = new StringBuilder();
            // находим переданный ID и удаляем строку
            for (String s : l) {
                if (Integer.parseInt(args[1]) != (Integer.parseInt(s.substring(0, 8).trim()))) {
                    stringBuilder.append(s).append("\n");
                }
            }
            FileWriter writer = new FileWriter(f);
            writer.append(stringBuilder.toString());
            writer.flush();
            sc.close();
            reader.close();
            writer.close();

        } else if (args[0].equals("-u")){
            // определяем productName из переданных данных добавляем пробелы
            StringBuilder productName = new StringBuilder();
            for (int i = 2; i < args.length - 2; i++) {
                productName.append(args[i]).append(" ");
            }
            // собираем всю переданную информацию для записи
            String all = String.format("%-8s",args[1])+String.format("%-30.30s", productName) + String.format("%-8s", args[args.length-2]) + String.format("%-4s", args[args.length-1]);
            StringBuilder stringBuilder1 = new StringBuilder();
            // находим переданный ID и удаляем строку
            for (String s : l) {
                if (Integer.parseInt(args[1]) != (Integer.parseInt(s.substring(0, 8).trim()))) {
                    stringBuilder1.append(s).append("\n");
                } else {
                    stringBuilder1.append(all).append("\n");
                }
            }
            FileWriter writer = new FileWriter(f);
            writer.append(stringBuilder1.toString());
            writer.flush();
            sc.close();
            reader.close();
            writer.close();
        }
    }
}
//Прайсы 2
//        CrUD для таблицы внутри файла
//        Считать с консоли имя файла для операций CrUD
//
//        Программа запускается с одним из следующих наборов параметров:
//        -u id productName price quantity
//        -d id
//
//        Значения параметров:
//        где id - 8 символов
//        productName - название товара, 30 символов
//        price - цена, 8 символов
//        quantity - количество, 4 символа
//        -u - обновляет данные товара с заданным id
//        -d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
//
//        В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
//        id productName price quantity
//        Данные дополнены пробелами до их длины
//
//        Пример:
//        19847   Шорты пляжные синие           159.00  12
//        198479  Шорты пляжные черные с рисунко173.00  17
//        19847983Куртка для сноубордистов, разм10173.991234
//
//
//        Требования:
//        1. Программа должна считать имя файла для операций CrUD с консоли.
//        2. При запуске программы без параметров список товаров должен остаться неизменным.
//        3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
//        4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
//        5. Созданные для файлов потоки должны быть закрыты.