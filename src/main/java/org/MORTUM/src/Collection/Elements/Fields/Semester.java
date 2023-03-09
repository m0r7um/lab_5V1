package org.MORTUM.src.Collection.Elements.Fields;

public enum Semester {
    FIRST,
    THIRD,
    FIFTH,
    SIXTH,
    EIGHTH;

    public String toString(String mode) {
        if (!mode.equals(("xml"))) {
            return this.name();
        } else {
            return "<Semester>" + this.name() + "</Semester>";
        }
    }
}
