package org.MORTUM.src.Commands.Execution;

import org.MORTUM.src.Collection.Elements.Fields.Color;
import org.MORTUM.src.Collection.Elements.Fields.FormOfEducation;
import org.MORTUM.src.Collection.Elements.Fields.Semester;
import org.MORTUM.src.Exceptions.ExitException;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public interface Readable {
    public HashMap<String, Object> readStudyGroup() throws ParseException, ExitException;

    public default HashMap<String, Object> readAdmin(Scanner scanner) throws ParseException, ExitException {
        return null;
    }

    public default HashMap<String, Object> readAdmin() throws ParseException, ExitException {
        return null;
    }

    default Semester readSemester(Scanner scanner) throws ExitException {
        return null;
    }
    default Semester readSemester() throws ExitException {
        return null;
    }

    default FormOfEducation readFormOfEducation(Scanner scanner) throws ExitException {
        return null;
    }

    default FormOfEducation readFormOfEducation() throws ExitException {
        return null;
    }

    public default Color readColor(Scanner scanner) throws ExitException {
        return null;
    }

    public default Color readColor() throws ExitException {
        return null;
    }

    public default Date readDate(Scanner scanner) throws ParseException, ExitException {
        return null;
    }

    public default Date readDate() throws ParseException, ExitException {
        return null;
    }

    public default String[] readCommand() {
        return new String[0];
    }

    public default String[] readCommand(String path) throws ParseException, FileNotFoundException {
        return null;
    }

    void setScanner(Scanner scanner);

    Scanner getScanner();
}
