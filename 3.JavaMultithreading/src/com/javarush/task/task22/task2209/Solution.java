package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder stringList = new StringBuilder();
        String line;
        while ((line = reader1.readLine()) != null){
            stringList.append(line).append(" ");
        }
        reader1.close();
        String[] strings = stringList.toString().split(" ");

        //...
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words.length==0) return new StringBuilder("");

        List<String> strings1 = new ArrayList<>(Arrays.asList(words));
        int count = 0;
        while(count<strings1.size()){
            Collections.shuffle(strings1);

            for (int i = 0; i<strings1.size()-1; i++){
                StringBuilder stringBuilder = new StringBuilder(strings1.get(i));
                StringBuilder stringBuilder1 = new StringBuilder(strings1.get(i+1));
                char s1 = stringBuilder.charAt(stringBuilder.length()-1);
                char s2 = stringBuilder1.charAt(0);
                if(Character.toString(s1).equalsIgnoreCase(Character.toString(s2))){
                    count++;
                } else count = 0;
            }
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        for (String s: strings1){
            stringBuilder2.append(s).append(" ");
        }

        return stringBuilder2.deleteCharAt(stringBuilder2.length()-1);
    }
}