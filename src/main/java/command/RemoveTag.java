package command;

import action.BotManagement;
import dao.DAOExecutor;
import org.telegram.telegrambots.api.objects.Message;

public class RemoveTag implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        DAOExecutor daoExecutor = new DAOExecutor();
        boolean result = daoExecutor.removeIllegalTag(message.getFrom().getId(), message.getText());
        System.out.println("тег удален");
        if (result) {
            botManagement.sendMsg(message, "Illegal Tag " + message.getText() + " deleted");
        } else {
            botManagement.sendMsg(message, "Tag " + message.getText() + " does not exists");
        }

    }

}
