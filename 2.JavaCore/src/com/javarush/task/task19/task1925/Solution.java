package com.javarush.task.task19.task1925;

import java.io.*;
import java.security.KeyStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
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
        List<String> strings = Arrays.asList(str1.toString().split("\\s"));
        List<String> stringsFinal = new ArrayList<>();
        for (int i = 0; i<strings.size(); i++){
            if(strings.get(i).length()>6){
                stringsFinal.add(strings.get(i));
                stringsFinal.add(",");
            }
        }
        for (int i = 0; i<stringsFinal.size()-1; i++){
            writer.write(stringsFinal.get(i));
        }
        writer.close();
    }
}
