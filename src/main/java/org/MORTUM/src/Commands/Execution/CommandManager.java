package org.MORTUM.src.Commands.Execution;


import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.*;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.FileProcessing.ScriptReader;
import org.MORTUM.src.FileProcessing.XMLFileWriter;
import org.apache.commons.collections4.queue.CircularFifoQueue;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    static private HashMap<String, Command> commandsAndNames = new HashMap<>();
    CircularFifoQueue<Command> history = new CircularFifoQueue<>(12);
    Readable handler;

    public CommandManager(CollectionHolder C, XMLFileWriter w, ScriptReader sr) {
        commandsAndNames.put("help", new HelpCommand(this));
        commandsAndNames.put("info", new InfoCommand(C));
        commandsAndNames.put("show", new ShowCommand(C));
        commandsAndNames.put("add", new AddElementCommand(C));
        commandsAndNames.put("update", new UpdateCommand(C));
        commandsAndNames.put("remove_by_id", new RemoveByIdCommand(C));
        commandsAndNames.put("clear", new ClearCommand(C));
        commandsAndNames.put("save", new SaveCommand(C, w));
        commandsAndNames.put("execute_script", new ExecuteScriptCommand(sr, this));
        commandsAndNames.put("exit", new ExitCommand());
        commandsAndNames.put("remove_head", new RemoveHeadCommand(C));
        commandsAndNames.put("remove_lower", new RemoveLowerCommand(C));
        commandsAndNames.put("history", new HistoryCommand(this));
        commandsAndNames.put("count_by_semester_enum", new CountBySemesterEnum(C));
        commandsAndNames.put("print_field_descending_students_count", new PrintFieldDescendingStudentsCount(C));
    }

    public CommandManager(CommandManager c, InputMode mode) {
        commandsAndNames = c.getCommandHashMap();
        this.handler = null;
        switch (mode)
        {
            case CLI_MODE -> handler = new CLIReader();
            case FILE_MODE -> handler = new ScriptReader();
        }
        commandsAndNames.remove("add");
        commandsAndNames.remove("update");
        commandsAndNames.put("add", new AddElementCommand(CollectionHolder.getInstance(), handler));
        commandsAndNames.put("update", new UpdateCommand(CollectionHolder.getInstance(), handler));
    }
    public HashMap<String, Command> getCommandHashMap() {
        return commandsAndNames;
    }
    public CircularFifoQueue<Command> getHistory() {
        return history;
    }
    public void addHistory(Command command){
        this.history.add(command);
    }
    public void setHandler(Readable handler) {
        this.handler = handler;
    }
    public Readable getHandler(){
        return handler;
    }
}
