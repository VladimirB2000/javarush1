package com.javarush.task.task19.task1906;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileReader reader1 = new FileReader(reader.readLine());
            FileWriter writer = new FileWriter(reader.readLine());
            reader.close();
            char[] buf = new char[256];
            int c;
            while ((c = reader1.read(buf))>0){
                if(c<256){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            reader1.close();
            for (int i = 1; i< buf.length; i +=2 ){
                writer.write(buf[i]);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}