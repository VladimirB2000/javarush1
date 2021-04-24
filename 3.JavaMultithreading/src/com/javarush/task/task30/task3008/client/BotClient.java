package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.IOException;

public class BotClient extends Client{
    public class BotSocketThread extends SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.split(":").length==2) {
                SimpleDateFormat dateFormat;
                switch (message.substring(message.indexOf(":") + 2)) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        dateFormat = null;
                }
                if (dateFormat != null)
                    sendTextMessage("Информация для " + message.substring(0, message.indexOf(':')) + ": " + dateFormat.format(Calendar.getInstance().getTime()));
            }
        }
    }
        protected SocketThread getSocketThread() {
            return new BotSocketThread();
        }
        protected boolean shouldSendTextFromConsole(){
            return false;
        }
        protected String getUserName(){
            return "date_bot_"+(int) (Math.random()*100);
        }



    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
