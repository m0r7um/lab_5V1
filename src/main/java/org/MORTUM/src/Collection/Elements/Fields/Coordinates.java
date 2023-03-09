package org.MORTUM.src.Collection.Elements.Fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Coordinates")
public class Coordinates {
    private double x; //Максимальное значение поля: 674
    private Double y; //Поле не может быть null
    public double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }
    public Coordinates(double x, Double y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {
        this.x = 0;
        this.y = 0.0;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }

    public String toString(String mode){
        if (!mode.equals(("xml"))) {
            return  "\n(x, y): (" + x + ", " + y + ")";
        } else{
            return "<Coordinates>\n" +
                    "\t<x>" + x + "</x>\n" +
                    "\t<y>" + y + "</y>\n" +
                    "</Coordinates>";
        }
    }
}
