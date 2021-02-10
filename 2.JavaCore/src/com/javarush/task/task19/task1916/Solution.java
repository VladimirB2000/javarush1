package com.javarush.task.task19.task1916;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader1 = new FileReader(reader.readLine());
        FileReader reader2 = new FileReader(reader.readLine());
        reader.close();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        char r1;
        char r2;
        while (reader1.ready()) {
            r1 = (char) reader1.read();
            str1.append(r1);
        }
        reader1.close();
        String[] strings1 = str1.toString().split("\\r\\n");
        List<String> f1 = new ArrayList<>(Arrays.asList(strings1));

        while (reader2.ready()){
            r2 = (char) reader2.read();
            str2.append(r2);
        }
        reader2.close();
        String[] strings2 = str2.toString().split("\\r\\n");
        List<String> f2 = new ArrayList<>(Arrays.asList(strings2));

        int oldFileLine = 0;
        int newFileLine = 0;

        while ((oldFileLine < f1.size()) && (newFileLine < f2.size())) {

            if (f1.get(oldFileLine).equals(f2.get(newFileLine))) {
                lines.add(new LineItem(Type.SAME, f1.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if ((newFileLine + 1 < f2.size()) && f1.get(oldFileLine).equals(f2.get(newFileLine + 1))) {
                lines.add(new LineItem(Type.ADDED, f2.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLine + 1 < f1.size()) && f1.get(oldFileLine + 1).equals(f2.get(newFileLine))) {
                lines.add(new LineItem(Type.REMOVED, f1.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while (oldFileLine < (f1.size())) {
            lines.add(new LineItem(Type.REMOVED, f1.get(oldFileLine)));
            oldFileLine++;
        }
        while (newFileLine < (f2.size())) {
            lines.add(new LineItem(Type.ADDED, f2.get(newFileLine)));
            newFileLine++;
        }

    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}