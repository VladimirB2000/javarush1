package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/*
Что внутри папки?
*/

public class Solution extends  SimpleFileVisitor<Path>{
    static int countFiles = 0;
    static int countDir = 0;
    @Override
    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        countFiles++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        countDir++;
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = null;
        try {
            path = Paths.get(reader.readLine());
            Files.walkFileTree(path, new Solution());
            System.out.println("Всего папок - " + (Solution.countDir-1));
            System.out.println("Всего файлов - "+ Solution.countFiles);
            System.out.println("Общий размер - " + Files.size(path));
        } catch (Exception e) {
            System.out.println(path.getFileName() + " - не папка" );
        }
    }
}
