package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class ClearCommand extends Command {
    {
        name = "clear";
        description = "Clears the collection";
    }
    private final CollectionHolder receiver;

    public ClearCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        receiver.clearCollection();
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
