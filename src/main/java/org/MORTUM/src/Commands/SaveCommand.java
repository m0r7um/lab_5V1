package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.FileProcessing.XMLFileWriter;

public final class SaveCommand extends Command {
    {
        name = "save";
        description = "Saves the collection to a file";
    }

    private CollectionHolder receiver;;
    private XMLFileWriter writer;

    public SaveCommand(CollectionHolder receiver, XMLFileWriter writer){
        this.receiver = receiver;
        this.writer = writer;
    }

    @Override
    public void execute(String[] args) {
        receiver.saveCollection(writer);
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
