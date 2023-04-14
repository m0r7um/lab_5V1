package org.MORTUM.src.CLIProcessing;

import org.MORTUM.src.Collection.Elements.Fields.*;
import org.MORTUM.src.Commands.Execution.Readable;
import org.MORTUM.src.Exceptions.ExitException;
import org.MORTUM.src.Exceptions.WrongValueException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import static org.MORTUM.src.Collection.Elements.Fields.Color.*;
import static org.MORTUM.src.Collection.Elements.Fields.FormOfEducation.*;
import static org.MORTUM.src.Collection.Elements.Fields.Semester.*;

public class CLIReader implements Readable {
    Scanner scanner = new Scanner(System.in);

    private void exit(String line) throws ExitException {
        if (line.equals("EXIT")) {
            throw new ExitException();
        }
    }
    public String readName() throws ExitException {
        String name = scanner.nextLine();
        exit(name);
        return name;
    }
    public Coordinates readCoordinates() throws ExitException {
            System.out.println("Enter coordinates: ");
            System.out.println("Enter x: ");
            String line = scanner.nextLine();
            exit(line);
            double x;
            Double y;
            System.out.println("Enter y: ");
            line = scanner.nextLine();
            exit(line);
        try {
            x = Double.parseDouble(line);
            if (x > 674){
                throw new WrongValueException("Max. value of \"x\" is 674");
            }
            y = Double.parseDouble(line);
            return new Coordinates(x, y);
        } catch (NumberFormatException e) {
            System.out.println("Wrong coordinates. Please try again");
            return readCoordinates();
        } catch (WrongValueException e) {
            System.out.println(e.getMessage());
            return readCoordinates();
        }
    }
    private Long readStudentsCount() throws ExitException {
        String line = scanner.nextLine();
        exit(line);
        try {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            System.out.println("Wrong students count. Please try again");
            return readStudentsCount();
        }
    }
    private int readTransferredStudents() throws ExitException {
        String line = scanner.nextLine();
        exit(line);
        return Integer.parseInt(line);
    }
    public FormOfEducation readFormOfEducation() throws ExitException {
        System.out.println("Enter form of education: ");
        System.out.println("1 - DISTANCE_EDUCATION");
        System.out.println("2 - FULL_TIME_EDUCATION");
        System.out.println("3 - EVENING_CLASSES");
        String line = scanner.nextLine();
        exit(line);
        int choice = Integer.parseInt(line);
        return switch (choice) {
            case 1 -> DISTANCE_EDUCATION;
            case 2 -> FULL_TIME_EDUCATION;
            case 3 -> EVENING_CLASSES;
            default -> {
                System.out.println("Wrong form of education. Please try again");
                yield readFormOfEducation();
            }
        };
    }
    public Semester readSemester() throws ExitException {
        System.out.println("Enter semester (number before its name): ");
        System.out.println("1 - FIRST");
        System.out.println("3 - THIRD");
        System.out.println("5 - FIFTH");
        System.out.println("6 - SIXTH");
        System.out.println("8 - EIGHTH");
        String line = scanner.nextLine();
        exit(line);
        int choice = Integer.parseInt(line);
        return switch (choice) {
            case 1 -> FIRST;
            case 3 -> THIRD;
            case 5 -> FIFTH;
            case 6 -> SIXTH;
            case 8 -> EIGHTH;
            default -> {
                System.out.println("Wrong semester. Please try again");
                yield readSemester();
            }
        };
    }
    public Date readDate() throws ExitException {
        Date date;
            System.out.println("Enter birthday of the admin in format dd.MM.yyyy");
            String line = scanner.nextLine();
            exit(line);
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            format.setLenient(false);
            date = format.parse(line);
        } catch (ParseException e) {
            System.out.println("Error while reading date. Please try again");
            date = readDate();
        }
        return date;
    }

    public Color readColor(){
        try {
            System.out.println("1 - RED");
            System.out.println("2 - ORANGE");
            System.out.println("3 - YELLOW");
            System.out.println("4 - BLUE");
            System.out.println("5 - BLACK");
            System.out.println("6 - WHITE");
            int choice = Integer.parseInt(scanner.nextLine());
            return switch (choice) {
                case 1 -> RED;
                case 2 -> ORANGE;
                case 3 -> YELLOW;
                case 4 -> BLUE;
                case 5 -> BLACK;
                case 6 -> WHITE;
                default -> {
                    System.out.println("Wrong color. Please try again");
                    yield readColor();
                }
            };
        } catch (NumberFormatException e) {
            System.out.println("Wrong color. Please try again");
            return readColor();
        }
    }
    /**
     * Reads admin of the group from the console and returns it
     * @return Person
     * @see Person
     */
    public HashMap<String, Object> readAdmin() throws ExitException {
        HashMap<String, Object> admin = new HashMap<>();
        System.out.println("Enter name of the admin");
        admin.put("name", readName());
        admin.put("birthday", readDate());
        System.out.println("Enter eye color of the admin");
        admin.put("eyeColor",readColor());
        System.out.println("Enter hair color of the admin");
        admin.put("hairColor", readColor());
        return admin;
    }

    public HashMap<String, Object> readStudyGroup() throws ExitException, ParseException {
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
        parMap.put("groupAdmin", readAdmin());
        return parMap;
    }
    public String[] readCommand() {
        return scanner.nextLine().split(" ");
    }
    @Override
    public Scanner getScanner(){
        return scanner;
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
