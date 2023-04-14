package org.MORTUM.src.FileProcessing;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
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
    private final String path;
    public XMLFileWriter(String path) {
        this.path = path;
    }
    public void save(CollectionHolder collectionHolder) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionHolder.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(collectionHolder, new File(path));
            jaxbMarshaller.marshal(collectionHolder, System.out);
        } catch (JAXBException jaxbException) {
            jaxbException.printStackTrace();
        }
    }
}
