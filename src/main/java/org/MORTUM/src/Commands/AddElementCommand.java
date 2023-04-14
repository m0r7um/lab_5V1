package org.MORTUM.src.Commands;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Commands.Execution.Readable;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Exceptions.ExitException;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.ValidationElementsException;
import org.MORTUM.src.FileProcessing.ScriptReader;

import java.text.ParseException;
import java.util.Scanner;


public final class AddElementCommand extends Command{
    {
        name = "add";
        description = "Adds a new element to the collection";
    }
    private final CollectionHolder receiver;
    private Readable reader;
    public AddElementCommand(CollectionHolder receiver) {
        reader = new CLIReader();
        this.receiver = receiver;
    }

    public AddElementCommand(CollectionHolder receiver, Readable reader) {
        this.reader = reader;
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws UnnecessaryArgumentException, ParseException {
        if (args.length > 1) {
            throw new UnnecessaryArgumentException("This command doesn't need any arguments");
        }
        try{
            System.out.println(reader);
            receiver.addElement(reader.readStudyGroup());
        } catch (ExitException e) {
            System.out.println("Element adding cancelled");
            return;
        } catch (ValidationElementsException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Element added!");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setScanner(Scanner scanner){
        reader.setScanner(scanner);
    }
}

