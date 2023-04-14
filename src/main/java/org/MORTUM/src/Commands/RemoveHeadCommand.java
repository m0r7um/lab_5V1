package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;

public final class RemoveHeadCommand extends Command {
    {
        name = "remove_head";
        description = "Shows the first element of the collection and removes it";
    }
    private CollectionHolder receiver;

    public RemoveHeadCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        if (receiver.getCollection().size() == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        System.out.println(receiver.getCollection().get(0).toString("readable"));
        receiver.getCollection().remove(0);
        System.out.println("Element removed!");
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
