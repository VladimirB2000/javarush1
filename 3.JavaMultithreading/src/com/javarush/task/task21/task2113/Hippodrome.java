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

    static Hippodrome game;

    void run() throws InterruptedException {
        for (int i = 0; i<100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }
    void move(){
        for (int i = 0; i< horses.size(); i++){
            horses.get(i).move();
        }


    }

    void print(){
        for (int i = 0; i< horses.size(); i++){
            horses.get(i).print();
        }
        for (int i=0; i<10; i++){
            System.out.println();
        }


    }


    public static void main(String[] args) throws InterruptedException {

        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Ivan", 3, 0));
        horses.add(new Horse("Maria", 3, 0));
        horses.add(new Horse("nata", 3, 0));
        game = new Hippodrome(horses);
        game.run();



    }
}