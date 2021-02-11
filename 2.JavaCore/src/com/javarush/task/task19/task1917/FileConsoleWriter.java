package com.javarush.task.task19.task1917;


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
Свой FileWriter
*/

public class FileConsoleWriter {
    public static void main(String[] args) throws IOException {

    }
    private FileWriter fileWriter;

    FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    FileConsoleWriter(FileDescriptor fileDescriptor){
        this.fileWriter = new FileWriter(fileDescriptor);
    }
    FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }
    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf, off, len));
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off+len));

    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }
    public void close() throws IOException{
        fileWriter.close();
    }
}
