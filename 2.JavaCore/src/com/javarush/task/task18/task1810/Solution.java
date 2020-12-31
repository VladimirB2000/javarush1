package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner sc = new Scanner(System.in);
        while (true){
            FileInputStream fileInputStream = new FileInputStream(sc.nextLine());
            if (fileInputStream.available()<1000){
                fileInputStream.close();
                break;
            }
        }
        throw new DownloadException();
    }
    public static class DownloadException extends Exception {
    }
}
