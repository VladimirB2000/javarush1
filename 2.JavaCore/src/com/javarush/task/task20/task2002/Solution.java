package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\vladi\\Desktop\\ww.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\vladi\\Desktop\\ww.txt");

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Иван");
            user.setLastName("Иванов");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUsersPresent = users !=null ? "yes" : "no";
            printWriter.print(isUsersPresent+"\n");
            printWriter.flush();
            if(this.users.size() > 0){
                for (User user: this.users){
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                    printWriter.flush();

                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersPresent = reader.readLine();
            if (isUsersPresent.equals("yes")){
                while (reader.ready()){
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    Date date = new Date(Long.parseLong(reader.readLine()));
                    user.setBirthDate(date);
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    this.users.add(user);}
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
//    Читаем и пишем в файл: JavaRush
//        Реализуй логику записи в файл и чтения из файла для класса JavaRush.
//        Метод main реализован только для тебя и не участвует в тестировании.
//
//
//        Требования:
//        1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
//        2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
//        3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
//        4. Класс Solution.JavaRush должен быть публичным.
//        5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
