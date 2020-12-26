package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(sc.nextLine());
        int min = Integer.MAX_VALUE;
        while ((fileInputStream.available()> 0 )){
            int data = fileInputStream.read();
            if(min > data) min = data;
        }
        System.out.println(min);
        sc.close();
        fileInputStream.close();


    }
}