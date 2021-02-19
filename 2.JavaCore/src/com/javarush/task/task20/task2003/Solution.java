package com.javarush.task.task20.task2003;

import javax.lang.model.util.Elements;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.security.KeyStore;
import java.util.*;

/*
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties p = new Properties();
        for (Map.Entry entry: runtimeStorage.entrySet() ){
            p.setProperty((String) entry.getKey(), (String) entry.getValue());
        }
        p.store(outputStream, "runtimeStorage");

    }

    public static void load(InputStream inputStream) throws IOException {
        Properties p = new Properties();
        p.load(inputStream);
        Set set = p.entrySet();

        // iterate over the set
        Iterator itr = set.iterator();
        while (itr.hasNext()) {

            // print each property
            Map.Entry entry = (Map.Entry)itr.next();
            runtimeStorage.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
