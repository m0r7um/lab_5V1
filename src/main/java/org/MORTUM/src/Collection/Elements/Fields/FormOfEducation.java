package org.MORTUM.src.Collection.Elements.Fields;

public enum FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    public String toString(String mode) {
        if (!mode.equals(("xml"))) {
            return this.name();
        } else {
            return "<FormOfEducation>" + this.name() + "</FormOfEducation>";
        }
    }
}
