package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader1 = new FileReader(args[0]);
        StringBuilder str1 = new StringBuilder();
        char r1;
        while (reader1.ready()) {
            r1 = (char) reader1.read();
            str1.append(r1);
        }
        reader1.close();
        String[] strings1 = str1.toString().split("\\s+");

        TreeMap<String, Double> nameSal = new TreeMap<>();
        for (int i = 0; i<strings1.length; i=i+2){
            if (!nameSal.containsKey(strings1[i])){
                nameSal.put(strings1[i], Double.parseDouble(strings1[i+1]));
            } else {
                double newSal = nameSal.get(strings1[i]);
                nameSal.put(strings1[i], newSal+Double.parseDouble(strings1[i+1]));
            }
        }
        for (Map.Entry<String, Double> e : nameSal.entrySet())
            System.out.println(e.getKey()
                    + " "
                    + e.getValue());

    }
}

//        Требования:
//        1. Программа НЕ должна считывать данные с консоли.
//        2. Программа должна считывать содержимое файла (используй FileReader).
//        3. Поток чтения из файла (FileReader) должен быть закрыт.
//        4. Программа должна выводить в консоль каждое имя и сумму всех его значений,
//        все данные должны быть отсортированы в возрастающем порядке по имени.
