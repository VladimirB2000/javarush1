package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

import java.io.*;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true){
            String fil = sc.nextLine();
            if (fil.equals("exit")){
                break;
            } else {
                ReadThread readThread = new ReadThread(fil);
                readThread.start();
            }
        }
        sc.close();

    }

    public static class ReadThread extends Thread {
        private final String fileName;
        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            //implement constructor body
        }

        public void run(){
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
                List<Integer> list = new ArrayList<>();
                Map<Integer, Integer> treemap = new TreeMap<>();
                while ((fis.available()> 0 )){
                    int data = fis.read();
                    list.add(data);
                }
                for (Integer temp: list){
                    Integer count = treemap.get(temp);
                    treemap.put(temp, (count == null) ? 1 : count +1);
                }
                ArrayList<Integer> values = new ArrayList<>(treemap.values());
                Collections.sort(values);
                Collection<Integer> collection =treemap.keySet();
                for (Integer key: collection){
                    Integer n = treemap.get(key);
                    if(key != null){
                        if(values.get(values.size()-1).equals(n)){
                            resultMap.put(fileName, key);
                        }
                    }
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}