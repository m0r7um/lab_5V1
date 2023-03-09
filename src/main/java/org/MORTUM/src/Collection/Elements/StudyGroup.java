package org.MORTUM.src.Collection.Elements;

import org.MORTUM.src.Collection.CollectionHolder;
import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
import org.MORTUM.src.Collection.Elements.Fields.FormOfEducation;
import org.MORTUM.src.Collection.Elements.Fields.Person;
import org.MORTUM.src.Collection.Elements.Fields.Semester;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;

/**
 * class describes element of collection
 * @author m0r7um
 * @since 1.0
 * @version 1.0
 * @see StudyGroup
 * @see Coordinates
 * @see FormOfEducation
 * @see Semester
 * @see Person
 */
@XmlRootElement(name = "StudyGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudyGroup implements Comparable<StudyGroup> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long studentsCount; //Значение поля должно быть больше 0
    private int transferredStudents; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(){
        creationDate = java.time.ZonedDateTime.now();
    }

    public String toString(String mode){
        return switch (mode) {
            // TODO add XML mode
            case ("xml"), ("readable") -> "ID: " + id +
                    "\nName: " + name +
                    "\nCoordinates: " + coordinates.toString(mode) +
                    "\nCreation date: " + creationDate.toString() +
                    "\nStudents count: " + studentsCount +
                    "\nForm of education: " + formOfEducation.toString(mode) +
                    "\nSemester: " + semesterEnum.toString(mode) +
                    "\nGroup admin: " + groupAdmin.toString(mode);
            default -> null;
        };
    }
    public Integer getId() {
        return id;
    }
    public void setId() {
        ArrayList<Integer> list = CollectionHolder.getInstance().getIdList();
        int maxValue = Integer.MAX_VALUE;
        for (int i = 1; i < maxValue; i++){
            if (!list.contains(i)) {
                this.id = i;
                break;
            }
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public long getStudentsCount() {
        return studentsCount;
    }
    public void setStudentsCount(long studentsCount) {
        this.studentsCount = studentsCount;
    }
    public int getTransferredStudents() {
        return transferredStudents;
    }
    public void setTransferredStudents(int transferredStudents) {
        this.transferredStudents = transferredStudents;
    }
    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }
    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }
    public Semester getSemesterEnum() {
        return semesterEnum;
    }
    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }
    public Person getGroupAdmin() {
        return groupAdmin;
    }
    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup o) {
        return this.id.compareTo(o.id);
    }

}
