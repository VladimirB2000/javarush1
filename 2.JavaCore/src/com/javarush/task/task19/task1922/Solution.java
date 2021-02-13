package com.javarush.task.task19.task1922;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
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
        int count = 0;

        for (String s: strings){
            for (String s1: words){
                if (s1.equals(s)) count++;
            }
        }
        if(count == 2){
            for (String s: strings){
                for (String s1: words){
                    if (s1.equals(s)) System.out.println(s1);;
                }
            }
        }
    }
}
