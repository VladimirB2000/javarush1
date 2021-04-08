package com.javarush.task.task25.task2512;

import java.util.*;

/*
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Deque<Throwable> tr = new ArrayDeque<>();

        while (e != null){
            tr.add(e);
            e = e.getCause();
        }

        while (!tr.isEmpty()){
            System.out.println(tr.pollLast().toString());
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
