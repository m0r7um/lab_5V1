package org.MORTUM.src.Commands;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;


public final class AddElementCommand extends Command{
    {
        name = "add";
        description = "Adds a new element to the collection";
    }
    private final CollectionHolder receiver;
    private final CLIReader reader;
    public AddElementCommand(CollectionHolder receiver) {
        reader = new CLIReader();
        this.receiver = receiver;
    }


    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        receiver.addElement(reader.buildStudyGroup());
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

