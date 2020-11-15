package com.javarush.task.task14.task1419;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception

        //2
        try {
            int array[] = new int[2];
            System.out.println("Доступ к третьему элементу:" + array[3]);
        }catch(ArrayIndexOutOfBoundsException b) {
            exceptions.add(b);
        }
        //3
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException j) {
            exceptions.add(j);
        }
        //3
        try {
            int a = 30, b = 0;
            int c = a/b;  // нельзя делить на ноль
            System.out.println ("Result = " + c);
        }
        catch(ArithmeticException d) {
            exceptions.add(d);
        }
        //4
        try {
            String a = null; // нулевое значение
            System.out.println(a.charAt(0));
        } catch(NullPointerException f) {
            exceptions.add(f);
        }
        //5
        try {
            String a = "This is like chipping "; // длина 22
            char c = a.charAt(24); // доступ к 25-му элементу
            System.out.println(c);
        }
        catch(StringIndexOutOfBoundsException g) {
            exceptions.add(g);
        }
        //6
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException h) {
            exceptions.add(h);
        }
        //7
        try {
            int num = Integer.parseInt ("akki") ;
            System.out.println(num);
        } catch(NumberFormatException i) {
            exceptions.add(i);
        }
        //8
        try {
            throw new ClassCastException();
        } catch (ClassCastException j) {
            exceptions.add(j);
        }
        //9

        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException k) {
            exceptions.add(k);
        }
        //10
        try {
            throw new InstantiationException();
        } catch (InstantiationException l) {
            exceptions.add(l);
        }


        //напишите тут ваш код

    }
}
