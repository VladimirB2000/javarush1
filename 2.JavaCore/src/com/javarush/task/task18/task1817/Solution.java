package com.javarush.task.task18.task1817;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = br.readLine()) != null){
            float ch = line.replaceAll("[.]", "").length();
            float chSpace = line.replaceAll("[^\\p{Space}]", "").length();
            float j = (chSpace/ch)*100;
            System.out.println((String.format("%.2f",j)));
        }
        br.close();
    }
}