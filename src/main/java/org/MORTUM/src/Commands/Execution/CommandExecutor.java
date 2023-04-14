package org.MORTUM.src.Commands.Execution;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.WrongArgumentException;

import java.text.ParseException;
import java.util.Arrays;

public class CommandExecutor {
    private final CommandManager commandManagerUser;
    private final CommandManager commandManagerNonUser;
    private final Readable Reader;

    /**
     * Constructor for CommandExecutor
     */
    public CommandExecutor(CommandManager commandManagerUser, CommandManager commandManagerNonUser, Readable Reader) {
        this.commandManagerUser = commandManagerUser;
        this.commandManagerNonUser = commandManagerNonUser;
        this.Reader = Reader;
    }

    /**
     * Executes the command with the given arguments and adds it to the history
     * @param args
     */
    public void execute(String[] args, InputMode mode) {
        try {
            switch (mode) {
                case CLI_MODE -> {
                    commandManagerUser.getCommandHashMap().get(args[0]).execute(args);
                    commandManagerUser.addHistory(commandManagerUser.getCommandHashMap().get(args[0]));
                }
                case FILE_MODE -> commandManagerNonUser.getCommandHashMap().get(args[0]).execute(args);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Command not found!");
        } catch (UnnecessaryArgumentException | WrongArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println("Wrong date format!");
        }
    }
    public void startProgram() {
        while (true) {
            execute(Reader.readCommand(), InputMode.CLI_MODE);
        }
    }
}
