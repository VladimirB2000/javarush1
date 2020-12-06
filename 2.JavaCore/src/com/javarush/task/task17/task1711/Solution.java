package com.javarush.task.task17.task1711;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=3){
                        if(args[i+1].equals("м")) allPeople.add(Person.createMale(args[i], formatter.parse(args[i+2])));
                        if(args[i+1].equals("ж")) allPeople.add(Person.createFemale(args[i], formatter.parse(args[i+2])));
                        System.out.println(allPeople.size()-1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=4){
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        if(args[i+2].equals("м")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        if(args[i+2].equals("ж")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(formatter.parse(args[i+3]));
                    }
                }break;
            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }break;
            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        if(allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)){
                            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " м "
                                    + formatter2.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                        }
                        if(allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)){
                            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " ж "
                                    + formatter2.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                        }
                    }
                }break;

        }
    }
}
