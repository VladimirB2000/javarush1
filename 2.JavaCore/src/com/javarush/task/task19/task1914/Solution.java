package com.javarush.task.task19.task1914;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        Scanner sc = new Scanner(result);
        List<String> allNum = new ArrayList<>();
        allNum = Arrays.asList(result.split("\\s"));
        switch (allNum.get(1)) {
            case ("+"):
                System.out.print(allNum.get(0)+" + "+allNum.get(2)+" = " + (Integer.parseInt(allNum.get(0)) + Integer.parseInt(allNum.get(2))));
                break;
            case ("-"):
                System.out.print(allNum.get(0)+" - "+allNum.get(2)+" = " + (Integer.parseInt(allNum.get(0)) - Integer.parseInt(allNum.get(2))));
                break;
            case ("*"):
                System.out.print(allNum.get(0)+" * "+allNum.get(2)+" = " + (Integer.parseInt(allNum.get(0)) * Integer.parseInt(allNum.get(2))));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

