package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        List<String> strings = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            strings.add(line);
        }
        reader.close();
        for(String s: strings){
            String[] strings1 = s.split(" ");
            String[] strings2 = s.split("\\w");
            PEOPLE.add(new Person(strings2[0].trim(), formatter.parse(strings1[strings1.length-3] + " " +
                    strings1[strings1.length-2] + " " + strings1[strings1.length - 1])));
        }
    }
}
