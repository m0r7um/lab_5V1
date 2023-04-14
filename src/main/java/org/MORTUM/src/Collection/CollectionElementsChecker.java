package org.MORTUM.src.Collection;

import org.MORTUM.src.Collection.Elements.Fields.*;
import org.MORTUM.src.Collection.Elements.StudyGroup;

import java.util.LinkedList;


/**
 * Class for checking elements of collection
 * @author m0r7um
 * @since 1.0
 * @version 1.0
 */
public class CollectionElementsChecker {
    public boolean checkName(StudyGroup element) {
        return element.getName() != null && !element.getName().isEmpty();
    }

    public boolean checkCoordinates(StudyGroup element) {
        return element.getCoordinates() != null &&
                (element.getCoordinates().getX() < 675) &&
                element.getCoordinates().getY() != null;
    }

    public boolean checkCreationDate(StudyGroup element) {
        return element.getCreationDate() != null;
    }

    public boolean checkStudentsCount(StudyGroup element) {
        return element.getStudentsCount() > 0;
    }

    public boolean checkFormOfEducation(StudyGroup element) {
        return element.getFormOfEducation() != null;
    }

    public boolean checkSemesterEnum(StudyGroup element) {
        return element.getSemesterEnum() != null;
    }
    public boolean checkTransferredStudents(StudyGroup element) {
        return element.getTransferredStudents() > 0;
    }
    public boolean checkGroupAdmin(StudyGroup element) {
        return element.getGroupAdmin() != null;
    }

    public boolean checkPersonName(StudyGroup element) {
        return element.getGroupAdmin().getName() != null && !element.getGroupAdmin().getName().isEmpty();
    }

    public boolean checkPersonHairColor(StudyGroup element) {
        return element.getGroupAdmin().getHairColor() != null;
    }

    public boolean checkPersonBirthday(StudyGroup element) {
        return element.getGroupAdmin().getBirthday() != null;
    }
    public boolean checkPersonEyeColor(StudyGroup element) {
        return element.getGroupAdmin().getEyeColor() != null;
    }

    public boolean checkElements(LinkedList<StudyGroup> collection) {
        boolean result = true;
        for (StudyGroup element : collection){
            result = result && (checkGroupAdmin(element));
            result = result && (checkPersonBirthday(element));
            result = result && (checkPersonEyeColor(element));
            result = result && (checkPersonName(element));
            result = result && (checkPersonHairColor(element));
            result = result && (checkTransferredStudents(element));
            result = result && (checkSemesterEnum(element));
            result = result && (checkStudentsCount(element));
            result = result && (checkFormOfEducation(element));
            result = result && (checkCreationDate(element));
            result = result && (checkCoordinates(element));
            result = result && (checkName(element));
        }
        return result;
    }
}
