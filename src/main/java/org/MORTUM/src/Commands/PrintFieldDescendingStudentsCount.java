package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

import java.util.ArrayList;

public final class PrintFieldDescendingStudentsCount extends Command {
    {
        name = "print_field_descending_students_count";
        description = "Prints the value of the studentsCount field of all elements in descending order";
    }
    private CollectionHolder receiver;

    public PrintFieldDescendingStudentsCount(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        ArrayList<Long> studentsCount = new ArrayList<>();
        for (StudyGroup element : receiver.getCollection()){
            studentsCount.add(element.getStudentsCount());
        }
        studentsCount.sort((o1, o2) -> (int) (o2 - o1));
        for (Long element : studentsCount){
            System.out.println(element);
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
