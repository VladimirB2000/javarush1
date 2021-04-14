package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);

        double median;
        if(array.length % 2 == 0)
            median = ((double)array[array.length/2]+ (double)array[array.length/2 -1])/2;
        else
            median = (double) array[array.length/2];

        Arrays.sort(array, Comparator.comparingDouble(x -> Math.abs(median - x)));





        //implement logic here
        return array;
    }
}
