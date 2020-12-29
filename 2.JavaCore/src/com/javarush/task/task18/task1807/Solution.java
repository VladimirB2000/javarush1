package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



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
        System.out.println(treemap.get(44));
        sc.close();
        fileInputStream.close();
    }
}
