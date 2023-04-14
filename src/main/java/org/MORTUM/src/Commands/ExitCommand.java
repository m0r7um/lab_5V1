package org.MORTUM.src.Commands;

import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class ExitCommand extends Command {
    {
        name = "exit";
        description = "Exits the program";
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        System.exit(0);
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
