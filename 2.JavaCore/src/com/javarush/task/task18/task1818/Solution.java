package com.javarush.task.task18.task1818;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileOutputStream oup1 = new FileOutputStream(sc.nextLine(), true);
        FileInputStream inp2 = new FileInputStream(sc.nextLine());
        FileInputStream inp3 = new FileInputStream(sc.nextLine());
        byte[] buffer1 = new byte[inp2.available()];
        byte[] buffer2 = new byte[inp3.available()];
        inp2.read(buffer1, 0, inp2.available());
        oup1.write(buffer1);
        inp3.read(buffer2, 0, inp3.available());
        oup1.write(buffer2);
        sc.close();
        oup1.close();
        inp2.close();
        inp3.close();

    }
}

