package com.javarush.task.task19.task1923;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        FileReader reader1 = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);

        StringBuilder str1 = new StringBuilder();
        char r1;
        while (reader1.ready()) {
            r1 = (char) reader1.read();
            str1.append(r1);
        }
        reader1.close();
        List<String> strings = Arrays.asList(str1.toString().split(" "));
        Pattern pattern = Pattern.compile(".+[0-9].+");
        for (String s: strings){
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()){
                writer.write(matcher.group() + " ");
            }
        }
        writer.close();
    }
}