package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class ExecuteScriptCommand extends Command {
    {
        name = "execute_script";
        description = "Reads and executes a script from a file";
    }
    private CollectionHolder receiver;
    public ExecuteScriptCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        // TODO Execute script command execution
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
