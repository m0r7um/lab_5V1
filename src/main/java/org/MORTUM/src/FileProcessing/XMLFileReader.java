package org.MORTUM.src.FileProcessing;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.StudyGroup;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class XMLFileReader {
    private final String path;

    public XMLFileReader(String path) {
        this.path = path;
    }

    public void load(CollectionHolder collectionHolder)  {
        try {
         // создаем JAXB-контекст и unmarshal
         var context = JAXBContext.newInstance(CollectionHolder.class);
         var um = context.createUnmarshaller();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        FileReader fileReader = new FileReader(path);
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(fileReader);
         var collection = um.unmarshal(xmlEventReader, CollectionHolder.class).getValue().getCollection();
        Collections.sort(collection);
        System.out.println(collection.size() + " elements loaded from file");
        System.out.println("Collection loaded from file");
        collectionHolder.setCollection(collection);
     } catch (JAXBException e) {
         System.out.println("Something went wrong while loading collection from file");
     } catch (FileNotFoundException e) {
         System.out.println("File not found");
         System.exit(0);
     } catch (XMLStreamException e) {
         System.out.println("File can't be parsed");
     }
    }
}
