package com.javarush.task.task19.task1926;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String str = "";

        while (reader1.ready()){
            str = reader1.readLine();
            StringBuilder stringBuilder = new StringBuilder(str);
            System.out.println(stringBuilder.reverse());
        }
        reader1.close();

    }
}