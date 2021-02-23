package com.javarush.task.task20.task2016;

import java.io.Serializable;
import java.io.*;

/*
Минимум изменений
*/

public class Solution {
    public static class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        C c = new C("имя");
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("s.dat"));
//        outputStream.writeObject(c);
//        outputStream.close();
//        System.out.println(c.name);
//
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("s.dat"));
//        C c2 = (C) inputStream.readObject();
//        inputStream.close();
//        System.out.println(c2.name);

    }
}
