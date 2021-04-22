package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void sendBroadcastMessage(Message message) throws IOException {
        connectionMap.forEach((name, connection) -> {
            try {
                connection.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
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
