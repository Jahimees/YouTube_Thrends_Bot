package command;

import action.BotManagement;
import dao.DAOExecutor;
import org.telegram.telegrambots.api.objects.Message;

public class RemoveTagCommand implements Command {

    public void execute(BotManagement botManagement) {
        Flag.setRemoveTagFlag(true);
        Message message = BotManagement.getMessage();
        botManagement.sendMsg(message, "Input IllegalTag");
    }
}
