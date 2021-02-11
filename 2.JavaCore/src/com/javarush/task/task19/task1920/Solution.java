package com.javarush.task.task19.task1920;

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
        ArrayList<Double> values = new ArrayList<>(nameSal.values());
        Collections.sort(values);
        Collection<String> collection =nameSal.keySet();
        for (String key: collection){
            Double n = nameSal.get(key);
            if(key != null){
                if(values.get(values.size()-1).equals(n)){
                    System.out.println(key);
                }
            }
        }
    }
}

