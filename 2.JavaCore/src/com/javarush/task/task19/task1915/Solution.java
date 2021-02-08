package com.javarush.task.task19.task1915;


import java.io.*;
import java.nio.charset.StandardCharsets;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        reader.close();
        fos.write(result.getBytes(StandardCharsets.UTF_8));
        fos.close();

        System.setOut(consoleStream);
        System.out.println(result);

    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

//    Требования:

//            10. Метод main(String[] args) класса Solution должен выводить и в консоль и в файл строку
//            выведенную методом printSomething() (используй FileOutputStream).
