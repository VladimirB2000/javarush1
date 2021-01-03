package com.javarush.task.task18.task1813;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream fileOutputStream;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName, true);
        this.fileOutputStream = fileOutputStream;
    }
    public void write(int b) throws IOException{
        fileOutputStream.write(b);
    }
    public void write(byte[] b) throws IOException{
        fileOutputStream.write(b);
    }
    public void write(byte[] b, int off, int len) throws IOException{
        fileOutputStream.write(b, off , len);
    }
    public void flush() throws IOException{
        fileOutputStream.flush();
    }
    public void close() throws IOException {
        flush();
        fileOutputStream.write("JavaRush © All rights reserved.".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}