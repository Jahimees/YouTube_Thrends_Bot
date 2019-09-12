package command;

public enum CommandEnum {
    HELP {
        {
            command = helpCommand;
        }
    },
    EMPTY {
        {
            command = emptyCommand;
        }
    },
    THRENDS {
        {
            command = threndsCommand;
        }
    },
    BANCHANNEL {
        {
            command = blacklistCommand;
        }
    },
    ADDILLEGALTAGS {
        {
            command = illegalTagCommand;
        }
    },
    UNBANCHANNEL {
        {
            command = unbanChannelCommand;
        }
    },
    REMOVETAG {
        {
            command = removeTagCommand;
        }
    };

    Command helpCommand = new HelpCommand();
    Command emptyCommand = new EmptyCommand();
    Command threndsCommand = new ThrendsCommand();
    Command blacklistCommand = new BanChannelCommand();
    Command illegalTagCommand = new AddIllegalTagCommand();
    Command removeTagCommand = new RemoveTagCommand();
    Command unbanChannelCommand = new UnbanChannelCommand();
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
