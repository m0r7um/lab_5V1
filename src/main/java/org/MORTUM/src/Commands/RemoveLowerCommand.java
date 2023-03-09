package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class RemoveLowerCommand extends Command {
    {
        name = "remove_lower";
        description = "Removes all elements lower than the specified one";
    }
    private CollectionHolder receiver;

    public RemoveLowerCommand(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        if (receiver.getCollection().size() == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        try {
            receiver.getCollection().removeIf(element ->
                    element.compareTo(receiver.getCollection().get(Integer.parseInt(args[1]) - 1)) < 0);
            System.out.println("Elements removed!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument!");
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
