package com.javarush.task.task14.task1409;

interface Bridge{
    default int getCarsCount(){
        return 3;
    }
}
