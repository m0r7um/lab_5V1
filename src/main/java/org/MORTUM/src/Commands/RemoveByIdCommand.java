package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class RemoveByIdCommand extends Command {
    {
        name = "remove_by_id";
        description = "Removes an element from the collection by its id";
    }
    private CollectionHolder receiver;

    public RemoveByIdCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        args[0] = args[0].trim();
        if (args[0].matches("\\d+")) {
            receiver.getCollection().removeIf(studyGroup -> studyGroup.getId() == Integer.parseInt(args[0]));
        } else {
            System.out.println("Invalid id");
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
