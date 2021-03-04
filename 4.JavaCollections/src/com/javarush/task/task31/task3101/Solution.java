package com.javarush.task.task31.task3101;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
class MyFileVisitor extends SimpleFileVisitor<Path>{
    public File file;
    Map<Path, StringBuilder> conteFiftyBytesFile = new TreeMap<Path, StringBuilder>();

    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) throws IOException {
        byte[] content = Files.readAllBytes(path);
        if (content.length<=50){
            List<String> lines = Files.readAllLines(path);
            StringBuilder s2 = new StringBuilder();
            for (String s: lines){
                s2.append(s).append("\n");
            }
            conteFiftyBytesFile.put(path.getFileName(), s2);
        }
        return FileVisitResult.CONTINUE;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[1]);
        File newFileName = new File(file.getParent() + "/" + "allFilesContent.txt");
        FileUtils.renameFile(file, newFileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
        MyFileVisitor fileVisitor = new MyFileVisitor();
        try {
            Files.walkFileTree(Paths.get(args[0]), fileVisitor);
            for (Map.Entry<Path, StringBuilder> entry: fileVisitor.conteFiftyBytesFile.entrySet()){
                writer.write(String.valueOf(entry.getValue()));}
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();
    }
}