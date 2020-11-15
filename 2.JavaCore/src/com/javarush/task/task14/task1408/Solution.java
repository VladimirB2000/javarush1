package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (Country.RUSSIA.equals(country)) return new RussianHen();
            if (Country.BELARUS.equals(country)) return new BelarusianHen();
            if (Country.MOLDOVA.equals(country)) return new MoldovanHen();
            if (Country.UKRAINE.equals(country)) return new UkrainianHen();
            return hen;
        }


          //напишите тут ваш код
        }}



