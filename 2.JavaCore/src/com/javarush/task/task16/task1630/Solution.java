package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Scanner;

/*
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        Scanner sc1 = new Scanner(System.in);
        firstFileName = sc1.nextLine();
        secondFileName = sc1.nextLine();
        sc1.close();
    }//add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, FileNotFoundException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();//add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws FileNotFoundException;

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String st = "";
        private String fullFileName;
        @Override
        public void setFileName(String fullFileName)  {
            this.fullFileName = fullFileName;

        }

        @Override
        public String getFileContent() {

            return st;
        }

        public void run(){
            try {
                Scanner sc2 = new Scanner(new File(fullFileName));
                while (sc2.hasNext()){
                    String st2 = sc2.nextLine();
                    st = st + st2;

                }
                sc2.close();
            } catch (FileNotFoundException e) {
                System.out.println("No file found");;
            }

        }
    }//add your code here - добавьте код тут
}
