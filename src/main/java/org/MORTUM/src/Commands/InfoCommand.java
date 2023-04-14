package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class InfoCommand extends Command {
    {
        name = "info";
        description = "Prints information about the collection (type, initialization date, number of elements, etc.)\nto the standard output stream";
    }
    private CollectionHolder receiver;

    public InfoCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        System.out.println("Collection contains elements of type StudyGroup" +
                "\nInitialization date: " + receiver.getInitializationDate() +
                "\nNumber of elements: " + receiver.getSize());
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
