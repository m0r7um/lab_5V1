package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class ShowCommand extends Command {
    {
        name = "show";
        description = "Prints all elements of the collection to the standard output stream in a string representation";
    }
    private final CollectionHolder receiver;

    public ShowCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        if (receiver.getCollection().size() == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        for (StudyGroup element : receiver.getCollection()){
            System.out.println(element.toString("readable"));
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
