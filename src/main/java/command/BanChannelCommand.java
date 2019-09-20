package command;

import action.BotManagement;
import org.telegram.telegrambots.api.objects.Message;

public class BanChannelCommand implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        Flag.setBanChannelFlag(true);
        botManagement.sendMsg(message, "Input channel name");
    }
}
