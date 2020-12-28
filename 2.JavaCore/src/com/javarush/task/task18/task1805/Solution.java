package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(sc.nextLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> treemap = new TreeMap<>();
        while ((fileInputStream.available()> 0 )){
            int data = fileInputStream.read();
            list.add(data);
        }
        for (Integer temp: list){
            Integer count = treemap.get(temp);
            treemap.put(temp, (count == null) ? 1 : count +1);
        }
        ArrayList<Integer> values = new ArrayList<>(treemap.values());
        Collection<Integer> collection =treemap.keySet();
        for (Integer key: collection){
            System.out.print(key + " ");
        }
        sc.close();
        fileInputStream.close();
    }
}
