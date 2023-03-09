package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Commands.Skeleton.Commandable;

import java.util.HashMap;

public final class GroupCountingByStudentsCount extends Command {
    {
        name = "group_counting_by_students_count";
        description = "Groups the elements of the collection by the value of the studentsCount field, " +
                "displaying the number of elements in each group";
    }
    private CollectionHolder receiver;
    public GroupCountingByStudentsCount(CollectionHolder receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        HashMap<Long, Long> groups = new HashMap<>();
        for (StudyGroup studyGroup : receiver.getCollection()){
            if (groups.containsKey(studyGroup.getStudentsCount())) {
                groups.put(studyGroup.getStudentsCount(), groups.get(studyGroup.getStudentsCount()) + 1);
            } else {
                groups.put(studyGroup.getStudentsCount(), (long) 1);
            }
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
