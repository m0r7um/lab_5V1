package org.MORTUM.src.Commands;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Execution.CommandManager;
import org.MORTUM.src.Commands.Execution.Readable;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.WrongArgumentException;
import org.MORTUM.src.FileProcessing.ScriptReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.MORTUM.src.Commands.Execution.InputMode.FILE_MODE;

public final class ExecuteScriptCommand extends Command {
    {
        name = "execute_script";
        description = "Reads and executes a script from a file";
    }
    private final ScriptReader receiver;
    private final CommandManager commandManager;
    public ExecuteScriptCommand(ScriptReader receiver, CommandManager commandManager) {
        this.receiver = receiver;
        this.commandManager = new CommandManager(commandManager, FILE_MODE);
    }

    @Override
    public void execute(String[] args)  {
        LinkedList<StudyGroup> copy = (LinkedList<StudyGroup>) CollectionHolder.getInstance().getCollection().clone();
        try{
            receiver.readScriptNames(args[1]);
            for (int i = 0; i < receiver.getDepth(); i++){
                for (String script : receiver.getScripts()) {
                    Scanner scanner = new Scanner(new File(script));
                    commandManager.getCommandHashMap().get("add").setScanner(scanner);
                    commandManager.getCommandHashMap().get("update").setScanner(scanner);
                    receiver.setScanner(scanner);
                    while (scanner.hasNextLine()) {
                        String[] command = receiver.readCommand();
                        System.out.println(Arrays.toString(command));
                        if (!command[0].equals("execute_script")) {
                            commandManager.getCommandHashMap().get(command[0]).execute(command);
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Command has to include 1 argument");
        } catch (ParseException | FileNotFoundException | UnnecessaryArgumentException | WrongArgumentException | NullPointerException |
                 NoSuchElementException e) {
            CollectionHolder.getInstance().setCollection(copy);
            e.printStackTrace();
            System.out.println("Wrong values. Changes are canceled");
        }
        receiver.clear();
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
