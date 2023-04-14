package org.MORTUM.src.Commands;

import org.MORTUM.src.Commands.Execution.CommandManager;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class HistoryCommand extends Command implements Commandable {
    {
        name = "history";
        description = "Prints the last 12 commands (without their arguments)";
    }
    private final CommandManager receiver;

    public HistoryCommand(CommandManager receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        for (Command command : receiver.getHistory()){
            System.out.println(command.getName());
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
