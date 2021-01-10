package com.javarush.task.task18.task1816;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[0]);
        List<Character> alphabet = new ArrayList<>(); // List for the alphabet letters
        int count = 0;
        for (char c = 'a'; c <='z'; ++c){
            alphabet.add(c);
        }for (char c = 'A'; c <='Z'; ++c){
            alphabet.add(c);
        }
        List<Character> charsOfFile = new ArrayList<>(); // List for the file characters
        while (inputStream.available()>0){
            char d = (char) inputStream.read();
            charsOfFile.add(d);
        }
        // compare two lists by characters
        for (Character value : alphabet) {
            for (Character character : charsOfFile) {
                if (value.equals(character)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        inputStream.close();
    }
}
//    Английские буквы
//    В метод main первым параметром приходит имя файла.
//        Посчитать количество букв английского алфавита, которое есть в этом файле.
//        Вывести на экран число (количество букв).
//        Закрыть потоки.
//
//
//        Требования:
//        1. Считывать с консоли ничего не нужно.
//        2. Создай поток чтения из файла, который приходит первым параметром в main.
//        3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
//        4. Нужно учитывать заглавные и строчные буквы.
//        5. Поток чтения из файла должен быть закрыт.