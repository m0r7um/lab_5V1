package org.MORTUM.src.Commands;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Execution.InputMode;
import org.MORTUM.src.Commands.Execution.Readable;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Exceptions.ExitException;
import org.MORTUM.src.Exceptions.ValidationElementsException;
import org.MORTUM.src.FileProcessing.ScriptReader;

import java.text.ParseException;

public final class UpdateCommand extends Command {
    {
        name = "update id";
        description = "Updates the value of the collection element whose id is equal to the specified one";
    }
    private final CollectionHolder receiver;
    private final Readable reader;
    private final ScriptReader scriptReader;


    public UpdateCommand(CollectionHolder receiver) {
        reader = new CLIReader();
        this.receiver = receiver;
        scriptReader = new ScriptReader();
    }

    public UpdateCommand(CollectionHolder receiver, Readable reader) {
        this.reader = reader;
        this.receiver = receiver;
        scriptReader = new ScriptReader();
    }

    @Override
    public void execute(String[] args) throws ParseException {
        try {
            for (StudyGroup studyGroup : receiver.getCollection()) {
                if (studyGroup.getId() == Integer.parseInt(args[1])) {
                    receiver.addElement(reader.readStudyGroup());
                    receiver.updateStudyGroup(studyGroup, reader.readStudyGroup());
                    System.out.println("Element updated!");
                    return;
                }
            }
            System.out.println("Element not found!");
        } catch (NumberFormatException e) {
            System.out.println("Id must be a number");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Id is not specified");
        } catch (ExitException e) {
            System.out.println("Element updating cancelled");
        } catch (ValidationElementsException e) {
            System.out.println(e.getMessage());
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
