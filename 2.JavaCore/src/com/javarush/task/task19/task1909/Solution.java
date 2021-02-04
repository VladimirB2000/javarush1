package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
        String s = String.valueOf(file1).replaceAll("\\.", "\\!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))){
            writer.write(s);
        }
        reader.close();
    }
}
