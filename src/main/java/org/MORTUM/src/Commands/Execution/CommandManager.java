package org.MORTUM.src.Commands.Execution;


import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Commands.*;
import org.MORTUM.src.Commands.Skeleton.Command;
import org.MORTUM.src.FileProcessing.XMLFileReader;
import org.MORTUM.src.FileProcessing.XMLFileWriter;
import org.apache.commons.collections4.queue.CircularFifoQueue;


import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    static private final HashMap<String, Command> commandsAndNames = new HashMap<>();
    CircularFifoQueue<Command> history = new CircularFifoQueue<>(12);

    public CommandManager(CollectionHolder C, XMLFileWriter w, XMLFileReader r){
        commandsAndNames.put("help", new HelpCommand(this));
        commandsAndNames.put("info", new InfoCommand(C));
        commandsAndNames.put("show", new ShowCommand(C));
        commandsAndNames.put("add", new AddElementCommand(C));
        commandsAndNames.put("update", new UpdateCommand(C));
        commandsAndNames.put("remove_by_id", new RemoveByIdCommand(C));
        commandsAndNames.put("clear", new ClearCommand(C));
        commandsAndNames.put("save", new SaveCommand(C));
        commandsAndNames.put("execute_script", new ExecuteScriptCommand(C));
        commandsAndNames.put("exit", new ExitCommand());
        commandsAndNames.put("remove_head", new RemoveHeadCommand(C));
        commandsAndNames.put("remove_lower", new RemoveLowerCommand(C));
        commandsAndNames.put("history", new HistoryCommand(this));
        commandsAndNames.put("count_by_semester_enum", new CountBySemesterEnum(C));
        commandsAndNames.put("print_field_descending_students_count", new PrintFieldDescendingStudentsCount(C));
    }
    public Map<String, Command> getCommandHashMap() {
        return commandsAndNames;
    }
    public CircularFifoQueue<Command> getHistory() {
        return history;
    }
    public void addHistory(Command command){
        this.history.add(command);
    }
}
