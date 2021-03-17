package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;

/*
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("name", "null");
        map.put("country", "null");
        map.put("city", "null");
        map.put("age", "null");

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> values = new ArrayList<>(params.values());
        for (String s: values)
            if (s != null){
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(entry.getValue() != null){
                        stringBuilder.append(entry.getKey()).append(" = '").
                                append(entry.getValue()).append("' and ");
                    }
                }
                return stringBuilder.delete(stringBuilder.length()-5, stringBuilder.length()).toString();
            }

        return "";
    }
}

//
//    Формируем WHERE
//    Сформируй часть запроса WHERE используя StringBuilder.
//        Если значение null, то параметр не должен попадать в запрос.
//
//        Пример:
//        {name=Ivanov, country=Ukraine, city=Kiev, age=null}
//
//        Результат:
//        name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
//
//
//        Требования:
//        1. Метод getQuery должен принимать один параметр типа Map.
//        2. Метод getQuery должен иметь тип возвращаемого значения String.
//        3. Метод getQuery должен быть статическим.
//        4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.