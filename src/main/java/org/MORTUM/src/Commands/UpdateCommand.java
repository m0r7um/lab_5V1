package org.MORTUM.src.Commands;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Skeleton.Command;

public final class UpdateCommand extends Command {
    {
        name = "update id";
        description = "Updates the value of the collection element whose id is equal to the specified one";
    }
    private final CollectionHolder receiver;
    private final CLIReader reader;


    public UpdateCommand(CollectionHolder receiver) {
        reader = new CLIReader();
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) {
        for (StudyGroup studyGroup : receiver.getCollection()) {
            if (studyGroup.getId() == Integer.parseInt(args[1])) {
                receiver.updateStudyGroup(studyGroup, reader.buildStudyGroup());
                System.out.println("Element updated!");
                return;
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
