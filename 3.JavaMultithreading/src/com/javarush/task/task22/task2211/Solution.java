package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, win);
        buffer = s.getBytes(utf);
        outputStream.write(buffer);

    }
}