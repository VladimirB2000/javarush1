package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker latte = new LatteMaker();
        latte.getRightCup();
        latte.putIngredient();
        latte.pour();

        TeaMaker tea = new TeaMaker();
        tea.getRightCup();
        tea.putIngredient();
        tea.pour();
    }
}
