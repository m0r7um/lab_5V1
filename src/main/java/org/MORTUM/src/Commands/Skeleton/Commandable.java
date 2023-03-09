package org.MORTUM.src.Commands.Skeleton;

import org.MORTUM.src.Exceptions.UnnecessaryArgumentException;
import org.MORTUM.src.Exceptions.WrongArgumentException;

public interface Commandable {
    public void execute(String[] args) throws UnnecessaryArgumentException, WrongArgumentException;
    public String getDescription();
    public String getName();
}
