package org.MORTUM.src.Commands.Skeleton;

import org.MORTUM.src.Commands.Execution.Readable;

import java.util.Scanner;

public abstract class Command implements Commandable {
    protected String name;
    protected String description;

    public void getReader() {
    }

    public void setReader(Readable reader){

    }

    public void setScanner(Scanner scanner){

    }
}
