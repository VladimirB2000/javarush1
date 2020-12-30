package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(sc.nextLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(sc.nextLine());
        byte[] buffer = new byte[fileInputStream.available()];
        byte[] buffer2 = new byte[fileInputStream.available()];
        fileInputStream.read(buffer, 0, buffer.length);

        for(int i = buffer.length-1; i >= 0; i-- ){
            buffer2[buffer.length-i-1] = buffer[i];
        }
        System.out.println(Arrays.toString(buffer2));
        fileOutputStream2.write(buffer2, 0, buffer2.length);
        fileInputStream.close();
        fileOutputStream2.close();

    }
}
