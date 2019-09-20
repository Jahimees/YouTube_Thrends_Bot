package command;

import action.BotManagement;
import org.telegram.telegrambots.api.objects.Message;

public class HelpCommand implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        botManagement.sendMsg(message, "Commands:\nhelp\nthrends\naddIllegalTags\nbanChannel\nunbanChannel\nremoveTag\n");
    }
}
