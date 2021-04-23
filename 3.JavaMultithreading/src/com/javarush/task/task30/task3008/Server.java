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
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message message = connection.receive();
                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                    continue;
                }

                String userName = message.getData();

                if (userName.isEmpty()) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }

                if (connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }
                connectionMap.put(userName, connection);

                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            connectionMap.forEach((name, connection1) -> {
                if (!name.equals(userName)){
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, name));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": "+ message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Message type error");
                }
            }
        }

        public void run(){
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());
            String userName = null;
            try (Connection connection =new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
            if (userName != null) {
                connectionMap.remove(userName);
                try {
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто");
        }

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