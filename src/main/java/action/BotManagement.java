package action;

import command.Command;
import command.CommandController;
import command.ThrendsCommand;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class BotManagement extends TelegramLongPollingBot {

    public static void initBot() {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new BotManagement());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        User user = message.getFrom();//////
        System.out.println(user.getId());/////
        Command command = CommandController.defineCommand(message);
        String text;
        if (command.getClass() == ThrendsCommand.class) {
            text = command.execute();
            String[] videos = text.split("╞");
            for (int i = 0; i < videos.length; i++) {
                sendMsg(message, clearMessage(videos[i]));
            }
        } else {
            text = command.execute();
            sendMsg(message, text);
        }

    }

    private String clearMessage(String dirty) {
        return dirty.replace("_", "\\_")
                .replace("*", "\\*")
                .replace("[", "\\[")
                .replace("`", "\\`");
    }

//    public void getUser(){
//        User user = new User();
//
//    }

    private void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "NAME_OF_BOT";
    }

    public String getBotToken() {
        return "831477134:AAEjlf5y2sbVjN5bhJ3WPCsggENYff57rLI";
    }
}
