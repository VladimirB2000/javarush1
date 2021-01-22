package com.javarush.task.task18.task1825;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> nameFiles = new ArrayList<>();
        String readString;
        while (!(readString = reader.readLine()).equals("end")){
            nameFiles.add(readString);
        }
        Collections.sort(nameFiles);
        String fileOutName = nameFiles.get(0).split("\\.")[0] + "." + nameFiles.get(0).split("\\.")[1];

        FileOutputStream out = new FileOutputStream(fileOutName, true);
        for (String s: nameFiles){

            FileInputStream fis = new FileInputStream(s);
            while (fis.available()>0){
                byte[] buffer  =new byte[fis.available()];
                fis.read(buffer);
                out.write(buffer);
            } fis.close();
        }
        out.close();
    }
}