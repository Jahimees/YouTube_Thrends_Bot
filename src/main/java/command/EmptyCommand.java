package command;

import action.BotManagement;
import org.telegram.telegrambots.api.objects.Message;

public class EmptyCommand implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        botManagement.sendMsg(message, "Empty command");
    }
}
