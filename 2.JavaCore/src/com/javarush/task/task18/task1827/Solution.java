package com.javarush.task.task18.task1827;

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
        String f = sc.nextLine();
        FileReader fr = new FileReader(f);
        BufferedReader reader = new BufferedReader(fr);
        List<String> l = new ArrayList<>();
        TreeSet<Integer> max = new TreeSet<>(); //для поиска максимального ID

        if(args.length == 0){
            sc.close();
            fr.close();
            reader.close();
        } else if(args[0].equals("-c")){
            // вычисляем максимальный ID через Treeset
            String line = reader.readLine();
            while (line!=null){
                l.add(line);
                line = reader.readLine();
            }
            for (int i=0; i<l.size(); i++){
                max.add(Integer.parseInt(l.get(i).substring(0,8).trim()));
            }
            // вычисляем productName из множества набора параметров после -с и добавляем пробелы
            StringBuilder productName = new StringBuilder();
            for(int i = 1; i< args.length-2; i++){
                productName.append(args[i]).append(" ");
            }
            // собираем всё в кучу для записи
            String all = String.format("%-8s", max.last()+1)+String.format("%-30.30s", productName) + String.format("%-8s", args[args.length-2]) + String.format("%-4s", args[args.length-1]);
            FileWriter writer = new FileWriter(f, true);
            // закрываем потоки
            writer.append('\n');
            writer.append(all);
            writer.flush();
            sc.close();
            fr.close();
            reader.close();
            writer.close();
        }
    }
}
