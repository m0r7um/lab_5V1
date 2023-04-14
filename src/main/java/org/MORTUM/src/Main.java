package org.MORTUM.src;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.Execution.CommandExecutor;
import org.MORTUM.src.Commands.Execution.CommandManager;
import org.MORTUM.src.Commands.Execution.InputMode;
import org.MORTUM.src.FileProcessing.ScriptReader;
import org.MORTUM.src.FileProcessing.XMLFileReader;
import org.MORTUM.src.FileProcessing.XMLFileWriter;


public class Main {
    public static void main(String[] args) {
        final String path = args[0];
        XMLFileReader xmlFileReader = new XMLFileReader(path);
        CommandManager commandManagerUser = new CommandManager(
                CollectionHolder.getInstance(),
                new XMLFileWriter(path),
                new ScriptReader());
        CommandManager commandManagerNonUser = new CommandManager(
                commandManagerUser,
                InputMode.FILE_MODE);
        CLIReader cliReader = new CLIReader();
        CommandExecutor commandExecutor = new CommandExecutor(commandManagerUser, commandManagerNonUser, cliReader);
        xmlFileReader.load(CollectionHolder.getInstance());
        commandExecutor.startProgram();
    }
}