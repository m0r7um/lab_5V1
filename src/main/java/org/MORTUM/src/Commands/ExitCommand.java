package org.MORTUM.src.Commands;

import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class ExitCommand extends Command {
    {
        name = "exit";
        description = "Exits the program";
    }

    @Override
    public void execute(String[] args) {
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
