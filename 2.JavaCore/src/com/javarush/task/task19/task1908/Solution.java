package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder file1 = new StringBuilder();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()))) {
            char c;
            while (reader1.ready()) {
                c = (char) reader1.read();
                file1.append(c);
            }
        }
        String[] s = String.valueOf(file1).split(" ");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))){
            for ( String s1: s){
                if(s1.matches("\\d+")) writer.write(s1+" ");
            }
        }
        reader.close();
    }
}