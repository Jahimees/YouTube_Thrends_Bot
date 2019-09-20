package command;

import action.BotManagement;
import org.telegram.telegrambots.api.objects.Message;

public class AddIllegalTagCommand implements Command {

    public void execute(BotManagement botManagement) {
        Flag.setAddIllegalTagFlag(true);
        Message message = BotManagement.getMessage();
        botManagement.sendMsg(message, "Input IllegalTag");

    }
}
