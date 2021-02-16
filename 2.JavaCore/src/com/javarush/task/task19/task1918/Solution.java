package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.io.*;



/*
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        String str;
        String file = "";
        while ((str = fileReader.readLine()) != null) {
            file += str;
        }

        Document doc = Jsoup.parse(file, "", Parser.xmlParser());
        Elements el = doc.select(args[0]);
        for (Element p : el) {
            System.out.println(p);
        }

        consoleReader.close();
        fileReader.close();
    }
}
