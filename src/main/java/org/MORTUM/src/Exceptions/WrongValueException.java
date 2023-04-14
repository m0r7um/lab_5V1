package org.MORTUM.src.Exceptions;

import org.apache.commons.collections4.functors.WhileClosure;

public class WrongValueException extends Exception {
    public WrongValueException(String message){
        super(message);
    }
}
