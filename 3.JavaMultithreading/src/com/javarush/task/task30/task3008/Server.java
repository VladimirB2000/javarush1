package com.javarush.task.task30.task3008;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try(ServerSocket ss = new ServerSocket(port)){

            ConsoleHelper.writeMessage("Server started");
            while (true){
                Handler handler = new Handler(ss.accept());
                handler.start();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

