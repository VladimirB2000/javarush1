package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread specialThread1 = new SpecialThread();//Add your code here - добавьте свой код тут
        SpecialThread specialThread2 = new SpecialThread();//Add your code here - добавьте свой код тут
        SpecialThread specialThread3 = new SpecialThread();//Add your code here - добавьте свой код тут
        SpecialThread specialThread4 = new SpecialThread();//Add your code here - добавьте свой код тут
        SpecialThread specialThread5 = new SpecialThread();

        Thread thread1 = new Thread(specialThread1);
        Thread thread2 = new Thread(specialThread2);
        Thread thread3 = new Thread(specialThread3);
        Thread thread4 = new Thread(specialThread4);
        Thread thread5 = new Thread(specialThread5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);
        System.out.println(list);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}