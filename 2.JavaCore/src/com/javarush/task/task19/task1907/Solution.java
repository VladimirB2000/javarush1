package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        try { filename = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new FileReader(filename));
            StringBuilder words = new StringBuilder();
            String s;
            while ((s = reader1.readLine()) != null){
                words.append(s);
            }
            int count = 0;
            String s1 = words.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
            for (String s2: s1.split(" ")) {
                if(s2.equals("world")) count++;
            }
            System.out.println(count);
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}