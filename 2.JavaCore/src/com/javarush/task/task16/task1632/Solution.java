package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new ThreadNumberOne());
        threads.add(new ThreadNumberTwo());
        threads.add(new ThreadNumberThree());
        threads.add(new ThreadNumberFour());
        threads.add(new ThreadNumberFive());
    }

    public static void main(String[] args) {




    }
    public static class ThreadNumberOne extends Thread {
        public void run() {
            Thread current = Thread.currentThread();
            while (true) {
            }
        }
    }
    public static class ThreadNumberTwo extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Thread.currentThread().interrupt();
                System.out.println("after");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadNumberThree extends Thread{

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadNumberFour extends Thread implements Message, Runnable {
        boolean j = true;

        @Override
        public void run() {
            while (j){
            }

        }
        @Override
        public void showWarning() {
            j = false;
        }


    }
    public static class ThreadNumberFive extends Thread{


            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
                ArrayList<Integer> list = new ArrayList<Integer>() ;
                int sum = 0;
                while (true)
                {
                    String s = null;
                    try {
                        s = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (s.equals("N")) break;
                    list.add(Integer.parseInt(s));
                }
                for (Integer f: list){
                    sum += f;
                }
                System.out.println(sum);
            }
        }
    }
