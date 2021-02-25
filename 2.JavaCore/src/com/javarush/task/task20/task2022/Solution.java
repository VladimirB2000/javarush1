package com.javarush.task.task20.task2022;
import java.io.*;

/*
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("t.dat");
        solution.writeObject("Hello world!");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("t.dat"));
        outputStream.writeObject(solution);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("t.dat"));
        Solution solution1 = (Solution) inputStream.readObject();
        inputStream.close();
        System.out.println(solution1);

    }
}
