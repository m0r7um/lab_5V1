package org.MORTUM.src.Commands;

import org.MORTUM.src.Commands.Execution.CommandManager;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class HelpCommand extends Command {
    {
        name = "help";
        description = "Prints a list of all commands and their descriptions";
    }
    private CommandManager receiver;

    public HelpCommand(CommandManager receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        for (Command values : receiver.getCommandHashMap().values()){
            System.out.println(values.getName() + " - " + values.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
}

