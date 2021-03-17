package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder stringList = new StringBuilder();
        String line;
        while ((line = reader1.readLine()) != null){
            stringList.append(line).append(" ");
        }
        reader1.close();
        String[] strings = stringList.toString().split(" ");
        List<String> strings1 = new ArrayList<>();
        strings1.addAll(Arrays.asList(strings));


        for (int i =0; i<strings1.size(); i++){
            for (int j = i+1; j<strings1.size(); j++){
                StringBuilder stringBuilder1 = new StringBuilder(strings1.get(j));
                if(!strings1.get(i).equals("") && strings1.get(i).equals(stringBuilder1.reverse().toString())) {
                    result.add(new Pair(strings1.get(i), strings1.get(j)));
                    System.out.println(strings1.get(i) + " " + strings1.get(j));
                    strings1.set(i, "");
                    strings1.set(j, "");
                    break;
                }
            }
        }


    }

    public static class Pair {
        String first;
        String second;

        Pair(){

        }

        public Pair(String str1, String str2) {
            first = str1;
            second = str2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
