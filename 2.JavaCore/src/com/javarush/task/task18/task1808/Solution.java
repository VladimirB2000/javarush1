package com.javarush.task.task18.task1808;

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
        FileOutputStream fileOutputStream3 = new FileOutputStream(sc.nextLine());

        byte[] buffer = new byte[fileInputStream.available()];
        System.out.println(buffer.length + " " + (buffer.length/2+buffer.length%2) + " " + buffer.length/2);
        fileInputStream.read(buffer, 0, buffer.length);
        fileOutputStream2.write(buffer, 0, buffer.length/2+buffer.length%2);
        fileOutputStream3.write(buffer, buffer.length/2+buffer.length%2, buffer.length/2);
        fileInputStream.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
