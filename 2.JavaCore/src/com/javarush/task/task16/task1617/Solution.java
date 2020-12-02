package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();

        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {

            try {
                System.out.print(numSeconds+" ");
                while (!isInterrupted() && numSeconds != 0){
                    Thread.sleep(1000);
                    numSeconds--;
                    if(numSeconds == 0) {
                        System.out.print("Марш!");
                    } else { System.out.print(numSeconds+ " ");}
                }

            } catch (InterruptedException e) {
                System.out.println("Прервано!");
            }

            //add your code here - добавь код тут
        }
    }
}
