package command;

import org.telegram.telegrambots.api.objects.Message;

public abstract class CommandController {
    private static CommandEnum commandEnum;

    public static Command defineCommand(Message command) {
        try {
            commandEnum = CommandEnum.valueOf(command.getText().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return CommandEnum.EMPTY.getCurrentCommand();
        }
        return commandEnum.getCurrentCommand();
    }
}
