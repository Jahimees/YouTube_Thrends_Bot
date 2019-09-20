package command;

import action.BotManagement;
import dao.DAOExecutor;
import org.telegram.telegrambots.api.objects.Message;

public class AddIllegalTag implements Command{

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        DAOExecutor daoExecutor = new DAOExecutor();
        daoExecutor.addIllegalTag(message.getFrom().getId(), message.getText());
        System.out.println("тег добавлен");
        botManagement.sendMsg(message, "Illegal tag " + message.getText() + " added");
    }
}
