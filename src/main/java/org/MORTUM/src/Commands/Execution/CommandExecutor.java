package org.MORTUM.src.Commands.Execution;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.WrongArgumentException;

import java.util.Arrays;

public class CommandExecutor {
    private final CommandManager commandManager;
    private final CLIReader cliReader;

    /**
     * Constructor for CommandExecutor
     * @param commandManager
     */
    public CommandExecutor(CommandManager commandManager, CLIReader cliReader) {
        this.commandManager = commandManager;
        this.cliReader = cliReader;
    }

    /**
     * Executes the command with the given arguments and adds it to the history
     * @param args
     */
    public void execute(String[] args) {
        try {
            commandManager.getCommandHashMap().get(args[0]).execute(args);
            commandManager.addHistory(commandManager.getCommandHashMap().get(args[0]));
        } catch (NullPointerException e) {
            System.out.println("Command not found!");
        } catch (UnnecessaryArgumentException | WrongArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void startProgram(String[] args) {
        while (true) {
            execute(args);
            args = cliReader.readCommand();
        }
    }
}
