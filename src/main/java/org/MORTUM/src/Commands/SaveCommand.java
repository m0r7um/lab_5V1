package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.FileProcessing.XMLFileWriter;

public final class SaveCommand extends Command {
    {
        name = "save";
        description = "Saves the collection to a file";
    }
    private CollectionHolder receiver;

    public SaveCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        receiver.saveCollection(args[1]);
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
