package org.MORTUM.src.CLIProcessing;

import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
import org.MORTUM.src.Collection.Elements.Fields.FormOfEducation;
import org.MORTUM.src.Collection.Elements.Fields.Person;
import org.MORTUM.src.Collection.Elements.Fields.Semester;
import org.MORTUM.src.Collection.Elements.StudyGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import static org.MORTUM.src.Collection.Elements.Fields.Color.*;
import static org.MORTUM.src.Collection.Elements.Fields.FormOfEducation.*;
import static org.MORTUM.src.Collection.Elements.Fields.Semester.*;

public class CLIReader {
    Scanner scanner = new Scanner(System.in);

    private String readName() {
        String line = scanner.nextLine();
        if (line.length() > 0) {
            return line;
        } else {
            return null;
        }
    }
    private Coordinates readCoordinates() {
        System.out.println("Enter coordinates: ");
        System.out.println("Enter x: ");
        String line = scanner.nextLine();
        double x;
        Double y;
        x = Double.parseDouble(line);
        System.out.println("Enter y: ");
        line = scanner.nextLine();
        if (line.length() > 0) {
            y = Double.parseDouble(line);
        } else {
            y = null;
        }
        return new Coordinates(x, y);
    }
    private Long readStudentsCount() {
        return Long.parseLong(scanner.nextLine());
    }
    private int readTransferredStudents() {
        return Integer.parseInt(scanner.nextLine());
    }
    private FormOfEducation readFormOfEducation() {
        System.out.println("Enter form of education: ");
        System.out.println("1 - DISTANCE_EDUCATION");
        System.out.println("2 - FULL_TIME_EDUCATION");
        System.out.println("3 - EVENING_CLASSES");
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> DISTANCE_EDUCATION;
            case 2 -> FULL_TIME_EDUCATION;
            case 3 -> EVENING_CLASSES;
            default -> null;
        };
    }
    private Semester readSemester() {
        System.out.println("Enter semester (number before its name): ");
        System.out.println("1 - FIRST");
        System.out.println("3 - THIRD");
        System.out.println("5 - FIFTH");
        System.out.println("6 - SIXTH");
        System.out.println("8 - EIGHTH");
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> FIRST;
            case 3 -> THIRD;
            case 5 -> FIFTH;
            case 6 -> SIXTH;
            case 8 -> EIGHTH;
            default -> null;
        };
    }
    private Date readDate() {
        Date date;
        try {
            System.out.println("Enter birthday of the admin in format dd.MM.yyyy");
            String line = scanner.nextLine();
            if (line.length() == 0) {
                date = null;
            } else {
                date = (new SimpleDateFormat("dd.MM.yyyy")).parse(line);
            }
        } catch (ParseException e) {
            System.out.println("Error while reading date. Please try again");
            date = readDate();
        }
        return date;
    }

    /**
     * Reads admin of the group from the console and returns it
     * @return Person
     * @see Person
     */
    private HashMap<String, Object> readGroupAdmin() {
        HashMap<String, Object> admin = new HashMap<>();
        System.out.println("Enter name of the admin");
        admin.put("name", readName());
        admin.put("birthday", readDate());
        System.out.println("Enter eye color of the admin");
        System.out.println("1 - RED");
        System.out.println("2 - ORANGE");
        System.out.println("3 - YELLOW");
        System.out.println("5 - BLUE");;
        System.out.println("7 - BLACK");
        System.out.println("8 - WHITE");
        int choice = Integer.parseInt(scanner.nextLine());
        admin.put("eyeColor", switch (choice) {
            case 1 -> RED;
            case 2 -> ORANGE;
            case 3 -> YELLOW;
            case 5 -> BLUE;
            case 7 -> BLACK;
            case 8 -> WHITE;
            default -> null;
        });
        System.out.println("Enter hair color of the admin");
        System.out.println("1 - RED");
        System.out.println("2 - ORANGE");
        System.out.println("3 - YELLOW");
        System.out.println("5 - BLUE");;
        System.out.println("7 - BLACK");
        System.out.println("8 - WHITE");
        choice = Integer.parseInt(scanner.nextLine());
        admin.put("hairColor", switch (choice) {
            case 1 -> RED;
            case 2 -> ORANGE;
            case 3 -> YELLOW;
            case 5 -> BLUE;
            case 7 -> BLACK;
            case 8 -> WHITE;
            default -> null;
        });
        return admin;
    }

    public HashMap<String, Object> buildStudyGroup() {
        HashMap<String, Object> parMap = new HashMap<>();
        System.out.println("Enter name of the group:");
        parMap.put("name", readName());
        System.out.println("Enter coordinates of the group:");
        parMap.put("coordinates", readCoordinates());
        System.out.println("Enter students count:");
        parMap.put("studentsCount", readStudentsCount());
        System.out.println("Enter transferred students count:");
        parMap.put("transferredStudents", readTransferredStudents());
        System.out.println("Enter form of education:");
        parMap.put("formOfEducation", readFormOfEducation());
        System.out.println("Enter semester:");
        parMap.put("semesterEnum", readSemester());
        System.out.println("Enter group admin:");
        parMap.put("groupAdmin", readGroupAdmin());
        return parMap;
    }
    public String[] readCommand() {
        while (true){
        return scanner.nextLine().split(" ");
        }
    }
}
