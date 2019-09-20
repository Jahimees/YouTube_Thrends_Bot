package command;

import action.BotManagement;
import org.telegram.telegrambots.api.objects.Message;

public class UnbanChannelCommand implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        Flag.setUnbanChannelFlag(true);
        botManagement.sendMsg(message, "Input channel name to unban");
    }
}
