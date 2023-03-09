package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

public final class CountBySemesterEnum extends Command {
    {
        name = "count_by_semester_enum";
        description = "Displays the number of elements whose semester enumeration field value is equal to the specified one";
    }
    private CollectionHolder receiver;
    public CountBySemesterEnum(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        int counter = 0;
        for (StudyGroup studyGroup : receiver.getCollection()) {
            if (studyGroup.getSemesterEnum().toString().equals(args[1])) {
                counter++;
            }
        }
        System.out.println("Number of elements with semester enumeration field value equal to " +
                args[0] + ": " + counter);
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
