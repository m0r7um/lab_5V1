package org.MORTUM.src.FileProcessing;

import org.MORTUM.src.Collection.Elements.Fields.Color;
import org.MORTUM.src.Collection.Elements.Fields.Coordinates;
import org.MORTUM.src.Collection.Elements.Fields.FormOfEducation;
import org.MORTUM.src.Collection.Elements.Fields.Semester;
import org.MORTUM.src.Commands.Execution.Readable;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScriptReader implements Readable {
    HashSet<String> scripts = new HashSet<>();
    long depth = 1;
    boolean recursion = false;
    Scanner scanner;

//    public ScriptReader(Scanner scanner)
//    {
//        this.scanner = scanner;
//    }

    public void readScriptNames(String path) {
        try {
            scripts.add(path);
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            Scanner scanner1 = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!recursionCheck(line) && !recursion) {
                    recursion = true;
                    System.out.println("Recursion detected! Specify recursion depth: ");
                    depth = scanner1.nextLong();
                    continue;
                }
                if (line.split(" ")[0].equals("execute_script")){
                    readScriptNames(line.split(" ")[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public String[] readCommand() {
        return scanner.nextLine().split(" ");
    }

    public HashMap<String, Object> readStudyGroup() throws ParseException {
        HashMap<String, Object> fields = new HashMap<>();
        var line = scanner.nextLine();
        fields.put("name", line);
        fields.put("coordinates", new Coordinates(Double.parseDouble(scanner.nextLine()),
                Double.parseDouble(scanner.nextLine())));
        fields.put("studentsCount", Long.parseLong(scanner.nextLine()));
        fields.put("transferredStudents", Integer.parseInt(scanner.nextLine()));
        fields.put("formOfEducation", readFormOfEducation(scanner));
        fields.put("semesterEnum", readSemester(scanner));
        fields.put("groupAdmin", readAdmin(scanner));
        System.out.println(fields);
        return fields;
    }

    public HashMap<String, Object> readAdmin(Scanner scanner) throws ParseException {
        HashMap<String, Object> admin = new HashMap<>();
        var line = this.scanner.nextLine();
        admin.put("name", line);
        admin.put("birthday", readDate(scanner));
        admin.put("eyeColor", readColor(scanner));
        admin.put("hairColor", readColor(scanner));
        return admin;
    }

    public Semester readSemester(Scanner scanner) {
        String semester = this.scanner.nextLine();
        System.out.println(semester + "!");
        return switch (semester) {
            case "FIRST" -> Semester.FIRST;
            case "THIRD" -> Semester.THIRD;
            case "FIFTH" -> Semester.FIFTH;
            case "SIXTH" -> Semester.SIXTH;
            case "EIGHTH" -> Semester.EIGHTH;
            default -> null;
        };
    }

    public FormOfEducation readFormOfEducation(Scanner scanner) {
        String form = this.scanner.nextLine();
        System.out.println(form + " !");
        return switch (form) {
            case "DISTANCE_EDUCATION" -> FormOfEducation.DISTANCE_EDUCATION;
            case "FULL_TIME_EDUCATION" -> FormOfEducation.FULL_TIME_EDUCATION;
            case "EVENING_CLASSES" -> FormOfEducation.EVENING_CLASSES;
            default -> null;
        };
    }

    public Color readColor(Scanner scanner) {
        String color = scanner.nextLine();
        System.out.println(color);
        return switch (color) {
            case "RED" -> Color.RED;
            case "ORANGE" -> Color.ORANGE;
            case "YELLOW" -> Color.YELLOW;
            case "BLUE" -> Color.BLUE;
            case "BLACK" -> Color.BLACK;
            case "WHITE" -> Color.WHITE;
            default -> null;
        };
    }

    public Date readDate(Scanner scanner) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setLenient(false);
        String test = this.scanner.nextLine();
        return format.parse(test);
    }

    public HashSet<String> getScripts(){
        return scripts;
    }

    public long getDepth() {
        return depth;
    }

    public void clear() {
        recursion = false;
        scripts.clear();
    }
    private boolean recursionCheck(String line) {
        String[] command = line.split(" ");
        if (command[0].equals("execute_script") && !command[1].equals(" ")) {
            return scripts.add(command[1]);
        }
        return true;
    }

    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }
}
