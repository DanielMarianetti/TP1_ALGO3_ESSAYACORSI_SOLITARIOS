package Comunes.Carta;

import java.io.Serializable;

public enum Palo implements Serializable {
    CORAZON("Rojo"),
    DIAMANTE("Rojo"),
    PICA("Negro"),
    TREBOL("Negro");

    public final String color;

    Palo(String color) {
        this.color = color;
    }
}
