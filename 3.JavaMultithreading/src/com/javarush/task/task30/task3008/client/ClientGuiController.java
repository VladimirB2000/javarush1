package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    protected SocketThread getSocketThread(){
        return new GuiSocketThread();
    }
    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }
    public String getServerAddress() {
        return view.getServerAddress();
    }
    public int getServerPort() {
        return view.getServerPort();
    }
    public String getUserName() {
        return view.getUserName();
    }
    public ClientGuiModel getModel(){
        return model;
    }


    public class GuiSocketThread extends SocketThread{
        public void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }
        public void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
        }
        public void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
        }
        public void notifyConnectionStatusChanged(boolean clientConnected){
            super.notifyConnectionStatusChanged(clientConnected);
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    public static void main(String[] args) {
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }
}
