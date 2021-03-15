package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String[] stringsWithoutTab = string.split("\\t");
        if (string == null) throw new TooShortStringException();

        if(stringsWithoutTab.length<3) throw new TooShortStringException();


        return stringsWithoutTab[1];
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \t обучения Java \t."));
    }
}