package com.javarush.task.task18.task1821;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;



public class Solution {
    public static void main(String[] args) throws Exception {
        //create stream
        FileInputStream fis = new FileInputStream(args[0]);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> treemap = new TreeMap<>();
        //read to list ASCII of chars
        while (fis.available() > 0){
            int d = fis.read();
            list.add(d);
        }
        // counting the number of characters added to the treemap
        for(Integer temp: list){
            Integer count = treemap.get(temp);
            treemap.put(temp, (count == null)? 1:count+1);
        }
        //adding keys to the array
        Integer[] c = treemap.keySet().toArray(new Integer[0]);
        //output data to the console
        for (int d : c){
            System.out.println((char) d + " " + treemap.get(d));
        }
        fis.close();
    }
}

//Требования:
//        1. Считывать с консоли ничего не нужно.
//        2. Создай поток для чтения из файла, который приходит первым параметром в main.
//        3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
//        4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
//        5. Поток для чтения из файла должен быть закрыт.