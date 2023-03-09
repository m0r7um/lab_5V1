package org.MORTUM.src;

import org.MORTUM.src.CLIProcessing.CLIReader;
import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
import org.MORTUM.src.Collection.Elements.StudyGroup;
import org.MORTUM.src.Commands.Execution.CommandExecutor;
import org.MORTUM.src.Commands.Execution.CommandManager;
import org.MORTUM.src.FileProcessing.XMLFileReader;
import org.MORTUM.src.FileProcessing.XMLFileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws JAXBException {
//        CircularFifoQueue<Command> history = new CircularFifoQueue<>(3);
//        history.add(new HelpCommand(new CommandManager(CollectionHolder.getInstance())));
//        history.add(new HelpCommand(new CommandManager(CollectionHolder.getInstance())));
//        history.add(new HelpCommand(new CommandManager(CollectionHolder.getInstance())));
//        for (Command c : history){
//            System.out.println(c.getName());
//        }
//        System.out.println(new Date());
//        System.out.println(Arrays.toString(Semester.class.getEnumConstants()));
//        for (Semester semester : Semester.values()) {
//            System.out.println(semester.getClass());
//        }
//        ArrayList<Integer> test = new ArrayList<>();
//        test.add(1);
//        test.add(2);
//        test.add(3);
//        test.add(4);
//        test.add(5);
//        test.sort((o1, o2) -> o2 - o1);
//        System.out.println(test);
//        CommandManager commandManager = new CommandManager(
//                CollectionHolder.getInstance(),
//                new XMLFileWriter(),
//                new XMLFileReader());
//        CLIReader cliReader = new CLIReader();
//        CommandExecutor commandExecutor = new CommandExecutor(commandManager, cliReader);
//        commandExecutor.startProgram(cliReader.readCommand());
            File file = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionHolder.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            CollectionHolder collectionHolder = CollectionHolder.getInstance();
            StudyGroup studyGroup = new StudyGroup();
            studyGroup.setCoordinates(new Coordinates(1.0, 1.0));
            collectionHolder.getCollection().add(studyGroup);
            jaxbMarshaller.marshal(collectionHolder, file);
            jaxbMarshaller.marshal(collectionHolder, System.out);




        //JaxbContext jaxbContext = new JaxbContext();
        //TODO split methods in Class CLIReader
        //
    }
}