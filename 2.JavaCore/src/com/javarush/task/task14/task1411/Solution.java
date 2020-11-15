package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        while (true) {
            String key = reader.readLine();
            if ("user".equals(key)) {
                person = new Person.User();
                doWork(person);
            } else if ("loser".equals(key)) {
                person = new Person.Loser();
                doWork(person);
            } else if ("coder".equals(key)) {
                person = new Person.Coder();
                doWork(person);
            } else if ("proger".equals(key)) {
                person = new Person.Proger();
                doWork(person);
            } else break;
        }
    }
    public static void doWork(Person person) {
        if(person instanceof Person.User)
            ((Person.User) person).live();
        else if(person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder)
            ((Person.Coder) person).writeCode();
        else if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
        // пункт 3
    }
    public interface Person{
        class User implements Person{
            void live() {
                System.out.println("жить");
            }
        }
        class Loser implements Person{
            void doNothing() {
                System.out.println("ничего не делать");
            }
        }
        class Coder implements Person{
            void writeCode(){
                System.out.println("писать код");
            }
        }
        class Proger implements Person{
            void enjoy(){
                System.out.println("отдыхать");
            }
        }
    }
}
