package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/*
Находим все файлы
*/
class MyFileVisitor extends SimpleFileVisitor<Path> {
    List<String> fileName = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileName.add(file.toAbsolutePath().toString());

        return FileVisitResult.CONTINUE;
    }
}
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(Paths.get(root), myFileVisitor);
        return myFileVisitor.fileName;

    }

    public static void main(String[] args) throws IOException {

    }
}

