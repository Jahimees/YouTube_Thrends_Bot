package command;

import action.BotManagement;
import dao.DAOExecutor;
import org.telegram.telegrambots.api.objects.Message;

public class UnbanChannel implements Command {
    @Override
    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        DAOExecutor daoExecutor = new DAOExecutor();
        daoExecutor.unbunChannel(message.getFrom().getId(), message.getText());
        System.out.println("Канал разбанен");
        botManagement.sendMsg(message, "Channel " + message.getText() + " unbanned");
    }
}
