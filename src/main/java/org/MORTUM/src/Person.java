package org.MORTUM.src;

import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person {


    public Person(String name, int age, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
    }

    public Person(String name, int age) {
        this(name, age, false);
    }
    private String name;
    private Integer age;
    private Boolean isMarried;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }
    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                '}';
    }
    public Person() {
    }
}
