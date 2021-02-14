package com.javarush.task.task19.task1924;

import java.io.*;
import java.security.KeyStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Хуан Хуанович
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader1 = new FileReader(reader.readLine());
        reader.close();
        StringBuilder str1 = new StringBuilder();
        char r1;
        while (reader1.ready()) {
            r1 = (char) reader1.read();
            str1.append(r1);
        }
        reader1.close();
        List<String> strings = Arrays.asList(str1.toString().split(" "));
        //перебор строк файла и поиск значений из словаря
        for (int i = 0; i < strings.size(); i++){
            Iterator iterator = map.keySet().iterator(); // перебор словаря внутри цикла, для каждого значения
            while(iterator.hasNext()){
                Integer key   = (int) iterator.next();
                String value = map.get(key);
                if (key.toString().equals(strings.get(i))){
                    strings.set(i, value);
                }
            }
        }
        for (String s: strings){
            System.out.print(s + " ");
        }
    }
}
