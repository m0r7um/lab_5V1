package org.MORTUM.src.Collection;

import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
import org.MORTUM.src.Collection.Elements.Fields.FormOfEducation;
import org.MORTUM.src.Collection.Elements.Fields.Person;
import org.MORTUM.src.Collection.Elements.Fields.Semester;
import org.MORTUM.src.Collection.Elements.StudyGroup;

import org.MORTUM.src.Collection.Elements.Fields.Color;
import org.MORTUM.src.FileProcessing.XMLFileReader;
import org.MORTUM.src.FileProcessing.XMLFileWriter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.*;

/**
 * Singleton class for holding collection and making basic operations with it
 * @author m0r7um
 * @since 1.0
 */
@XmlRootElement(name = "StudyGroups")
@XmlAccessorType(XmlAccessType.NONE)
public class CollectionHolder {
    @XmlElement(name = "group")
    private final LinkedList<StudyGroup> collection;
    private static CollectionHolder instance;
    private static Date initDate;
    private static XMLFileWriter collectionSaver;
    private static XMLFileReader collectionLoader;

    private CollectionHolder() {
        collection = new LinkedList<>();
    }

    /**
     * Returns stored collection
     * @return LinkedList<StudyGroup>
     */
    public LinkedList<StudyGroup> getCollection() {
        return collection;
    }

    /**
     * basic singleton realization
     *
     * @return instance of CollectionHolder
     */
    public static CollectionHolder getInstance() {
        if (instance == null) {
            instance = new CollectionHolder();
            initDate = new Date();
            collectionSaver = new XMLFileWriter();
            collectionLoader = new XMLFileReader();
        }
        return instance;
    }
    /**
     * Adds an element to collection and checks it for uniqueness
     */
    public void addElement(HashMap<String, Object> element) {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId();
        studyGroup.setName((String) element.get("name"));
        studyGroup.setCoordinates((Coordinates) element.get("coordinates"));
        studyGroup.setStudentsCount((Long) element.get("studentsCount"));
        studyGroup.setTransferredStudents((Integer) element.get("transferredStudents"));
        studyGroup.setFormOfEducation((FormOfEducation) element.get("formOfEducation"));
        studyGroup.setSemesterEnum((Semester) element.get("semesterEnum"));
        HashMap<String, Object> adminPar = (HashMap<String, Object>) element.get("groupAdmin");
        Person admin = new Person();
        admin.setName((String) adminPar.get("name"));
        admin.setBirthday((Date) adminPar.get("birthday"));
        admin.setEyeColor((Color) adminPar.get("eyeColor"));
        admin.setHairColor((Color) adminPar.get("hairColor"));
        studyGroup.setGroupAdmin(admin);
        collection.add(studyGroup);
        collection.sort(StudyGroup::compareTo);
    }

    /**
     * Removes definite element from collection
     * @param studyGroup
     */
    public void removeElement(StudyGroup studyGroup) {
        try {
            collection.remove(studyGroup);
        } catch (Exception e) {
            System.out.println("Элемент не найден");
        }
    }

    /**
     * Checks elements for any errors
     * @return true if there are no errors
     */
    public boolean checkElements(CollectionElementsChecker checker) {
        return checker.checkElements();
    }
    /**
     * Clears collection
     */
    public void clearCollection() {
        collection.clear();
    }
    /**
     * Returns size of collection
     * @return int
     */
    public int getSize() {
        return collection.size();
    }
    /**
     * Returns initialization date of collection
     * @return Date
     */
    public Date getInitializationDate() {
        return initDate;
    }
    /**
     * Returns list of ids of elements in collection
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getIdList() {
        ArrayList<Integer> idList = new ArrayList<>();
        for (StudyGroup studyGroup : collection) {
            idList.add(studyGroup.getId());
        }
        return idList;
    }

    public void updateStudyGroup(StudyGroup studyGroup, HashMap<String, Object> pars) {
        studyGroup.setName((String) pars.get("name"));
        studyGroup.setCoordinates((Coordinates) pars.get("coordinates"));
        studyGroup.setStudentsCount((Long) pars.get("studentsCount"));
        studyGroup.setTransferredStudents((Integer) pars.get("transferredStudents"));
        studyGroup.setFormOfEducation((FormOfEducation) pars.get("formOfEducation"));
        studyGroup.setSemesterEnum((Semester) pars.get("semesterEnum"));
        HashMap<String, Object> adminPar = (HashMap<String, Object>) pars.get("groupAdmin");
        Person admin = new Person();
        admin.setName((String) adminPar.get("name"));
        admin.setBirthday((Date) adminPar.get("birthday"));
        admin.setEyeColor((Color) adminPar.get("eyeColor"));
        admin.setHairColor((Color) adminPar.get("hairColor"));
        studyGroup.setGroupAdmin(admin);
        collection.sort(StudyGroup::compareTo);
    }
    public void saveCollection(String path) {
        collectionSaver.save(instance.getCollection(), new File(path));
    }
}
