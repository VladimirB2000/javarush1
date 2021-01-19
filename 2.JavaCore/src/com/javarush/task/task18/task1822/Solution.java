package com.javarush.task.task18.task1822;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;



public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(sc.nextLine()));
        List<String> l = new ArrayList<>();
        String line = reader.readLine();
        while (line != null){
            l.add(line);
            line = reader.readLine();
        }
        for (String s: l){
            String [] wordsFile = s.split(" ");
            for (int i = 0; i < wordsFile.length; i = i+4){
                if(Integer.parseInt(wordsFile[i]) == Integer.parseInt(args[0])){
                    for(int j = i; j < i+4; j++){
                        System.out.print(wordsFile[j]+ " ");
                    }
                }
            }
            wordsFile = null;
        }

        sc.close();
        reader.close();
    }
}

//        Требования:
//        1. Программа должна считать имя файла с консоли.
//        2. Создай для файла поток для чтения.
//        3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
//        4. Поток для чтения из файла должен быть закрыт.