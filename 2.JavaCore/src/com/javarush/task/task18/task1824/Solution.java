package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        while (true){
            Scanner sc = new Scanner(System.in);
            String fileName = null;
            FileInputStream fis = null;
            try {
                fileName = sc.nextLine();
                fis = new FileInputStream(new File(fileName));
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                sc.close();
                break;
            }
        }
    }
}
//        Требования:
//        1. Программа должна считывать имена файлов с консоли.
//        2. Для каждого файла нужно создавать поток для чтения.
//        3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
//        4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
//        5. Потоки для чтения из файла должны быть закрыты.
//        6. Команду "System.exit();" использовать нельзя.