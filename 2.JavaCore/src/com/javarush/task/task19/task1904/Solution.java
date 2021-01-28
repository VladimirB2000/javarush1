package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;

        }


        @Override
        public Person read() {
            String[] words = new String[0];
            Person person = null;
            try {
                words = fileScanner.nextLine().split(" ");
                person = new Person(words[1], words[2], words[0],
                        new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(words[3]+" "+ words[4]+" "+words[5]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return person;
        }
        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}