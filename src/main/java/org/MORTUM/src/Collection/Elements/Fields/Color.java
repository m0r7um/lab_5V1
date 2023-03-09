package org.MORTUM.src.Collection.Elements.Fields;

public enum Color {
    RED,
    BLACK,
    YELLOW,
    WHITE,
    BLUE,
    ORANGE;

    public String toString(String mode) {
        return switch (mode){
            case "xml" ->
                "<Color>" + this.name() + "</Color>";

            case "readable" ->
                this.name();

            default -> null;
        };
    }
}
