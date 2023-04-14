package org.MORTUM.src.Commands.Skeleton;

import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.WrongArgumentException;

import java.text.ParseException;

public interface Commandable {
    public void execute(String[] args) throws UnnecessaryArgumentException, WrongArgumentException, ParseException;
    public String getDescription();
    public String getName();
}
