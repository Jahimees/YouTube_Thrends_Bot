package command;

import action.BotManagement;
import dao.DAOExecutor;
import org.telegram.telegrambots.api.objects.Message;

public class BanChannel implements Command {
    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        DAOExecutor daoExecutor = new DAOExecutor();
        daoExecutor.banChannel(message.getFrom().getId(), message.getText());
        System.out.println("Канал забанен");
        botManagement.sendMsg(message, "Channel " + message.getText() + " banned");
    }
}
