package command;

public class HelpCommand implements Command {

    public String execute() {
        return "Commands:\nhelp\nthrends\naddIllegalTags\nbanChannel\nunbanChannel\nremoveTag\n";
    }
}
