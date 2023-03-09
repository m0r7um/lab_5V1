package org.MORTUM.src.Collection.Elements.Fields;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public String toString(String mode) {
        if (!mode.equals(("xml"))) {
            return "\nPerson: \n" +
                    "Name: " + name + "\n" +
                    "Birthday: " + birthday + "\n" +
                    "Eye color: " + eyeColor + "\n" +
                    "Hair color: " + hairColor;
        } else {
            return "<Person>\n" +
                    "\t<name>" + name + "</name>\n" +
                    "\t<birthday>" + birthday + "</birthday>\n" +
                    "\t<eyeColor>" + eyeColor + "</eyeColor>\n" +
                    "\t<hairColor>" + hairColor + "</hairColor>\n" +
                    "</Person>";
        }
    }
}
