package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

import java.io.*;
import java.util.*;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Scanner sc3 = new Scanner(System.in);
        String file1 = sc3.nextLine();
        String file2 = sc3.nextLine();
        Scanner sc1 = new Scanner(new File(file1));
        Scanner sc2 = new Scanner(new File(file2));
        String line = "";
        while (sc1.hasNext()){
            line = sc1.nextLine();
            allLines.add(line);
        }
        while (sc2.hasNext()){
            line = sc2.nextLine();
            forRemoveLines.add(line);
        }
        solution.joinData();
        sc1.close();
        sc2.close();
        sc3.close();
    }
    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}