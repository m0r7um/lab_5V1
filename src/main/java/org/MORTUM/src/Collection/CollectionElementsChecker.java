package org.MORTUM.src.Collection;

import org.MORTUM.src.Collection.Elements.Fields.*;


/**
 * Class for checking elements of collection
 * @author m0r7um
 * @since 1.0
 * @version 1.0
 */
public class CollectionElementsChecker {
    public boolean checkName(String name) {
        return name != null && !name.isEmpty();
    }

    public boolean checkCoordinates(Coordinates coordinates) {
        return coordinates != null;
    }

    public boolean checkCreationDate(String creationDate) {
        return creationDate != null;
    }

    public boolean checkStudentsCount(Integer studentsCount) {
        return studentsCount != null && studentsCount > 0;
    }

    public boolean checkFormOfEducation(FormOfEducation formOfEducation) {
        return formOfEducation != null;
    }

    public boolean checkSemesterEnum(Semester semesterEnum) {
        return semesterEnum != null;
    }
    public boolean checkTransferredStudents(Integer transferredStudents) {
        return transferredStudents > 0;
    }

    public boolean checkGroupAdmin(Person groupAdmin) {
        return groupAdmin != null;
    }

    public boolean checkPersonName(String personName) {
        return personName != null && !personName.isEmpty();
    }

    public boolean checkPersonHairColor(Color personHairColor) {
        return personHairColor != null;
    }

    public boolean checkPersonBirthday(java.util.Date personBirthday) {
        return personBirthday != null;
    }
    public boolean checkPersonEyeColor(Color personEyeColor) {
        return personEyeColor != null;
    }

    public boolean checkElements() {

        return false;
    }
}
