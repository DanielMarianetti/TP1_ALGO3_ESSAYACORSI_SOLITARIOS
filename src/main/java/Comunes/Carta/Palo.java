package Comunes.Carta;

public enum Palo {
    CORAZON("Rojo"),
    DIAMANTE("Rojo"),
    PICA("Negro"),
    TREBOL("Negro");

    public final String color;

    Palo(String color) {
        this.color = color;
    }
}
