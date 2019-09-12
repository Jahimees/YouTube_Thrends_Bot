package command;

public class AddIllegalTagCommand implements Command {
    @Override
    public String execute() {
        return "Illegal tags";
    }
}
