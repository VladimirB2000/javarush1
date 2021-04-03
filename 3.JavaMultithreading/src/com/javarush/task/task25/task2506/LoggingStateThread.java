package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread thread;
    LoggingStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        State state, lastState = null;
        do {
            state = thread.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        } while (state != State.TERMINATED);
    }
}
