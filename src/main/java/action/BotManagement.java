package action;

import command.*;
import entity.BannedChannel;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class BotManagement extends TelegramLongPollingBot {
    private static volatile Message message;

    public static void initBot() {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new BotManagement());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public static Message getMessage() {
        return message;
    }

    public static void setMessage(Message message) {
        BotManagement.message = message;
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        setMessage(message);
        String anotherCommand = getAnotherCommmand();
        switch (anotherCommand) {
            case "addIllegalFlag": {
                AddIllegalTag addIllegalTag = new AddIllegalTag();
                addIllegalTag.execute(this);
                break;
            }
            case "removeIllegalTag": {
                RemoveTag removeTag = new RemoveTag();
                removeTag.execute(this);
                break;
            }
            case "banChannel": {
                BanChannel banChannel = new BanChannel();
                banChannel.execute(this);
                break;
            }
            case "unbanChannel": {
                UnbanChannel unbanChannel = new UnbanChannel();
                unbanChannel.execute(this);
                break;
            }
            default: {
                Command command = CommandController.defineCommand(message);
                command.execute(this);
            }
        }
    }

    private String getAnotherCommmand() {
        if (Flag.isAddIllegalTagFlag()) {
            Flag.setAddIllegalTagFlag(false);
            return "addIllegalFlag";
        } else if (Flag.isRemoveTagFlag()) {
            Flag.setRemoveTagFlag(false);
            return "removeIllegalTag";
        } else if(Flag.isBanChannelFlag()) {
            Flag.setBanChannelFlag(false);
            return "banChannel";
        } else if(Flag.isUnbanChannelFlag()) {
            Flag.setUnbanChannelFlag(false);
            return "unbanChannel";
        }
        return "no";
    }

    public void sendMsg(Message message, String s) {
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
        return "YOUTUBE_THRENDS";
    }

    public String getBotToken() {
        return "";
    }
}
