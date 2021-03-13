package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }
    Hippodrome(List<Horse> horses){
        this.horses = horses;
        horses = new ArrayList<>();

    }

    public static void main(String[] args) {


    }
}