package org.MORTUM.src.FileProcessing;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class XMLFileWriter {
    public boolean save(LinkedList<StudyGroup> products, File file) {
        try {
            if (products.size() == 0){
                new FileWriter(file, false).close();
                return true;
            }
            var bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            var studyGroupsXml = CollectionHolder.getInstance();
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionHolder.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Marshal the StudyGroup list in file
            jaxbMarshaller.marshal(studyGroupsXml, System.out);
            bufferedWriter.close();
            return true;
        } catch (JAXBException | IOException jaxbException) {
            jaxbException.printStackTrace();
            return false;
        }
    }
}
