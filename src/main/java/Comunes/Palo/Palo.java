package Comunes.Palo;

import java.util.ArrayList;

public abstract class Palo {

    public static ArrayList<Palo> obtenerPalos(){
        ArrayList<Palo> palos = new ArrayList<>();
        palos.add(new Corazon());
        palos.add(new Diamante());
        palos.add(new Pica());
        palos.add(new Trebol());
        return palos;
    }
    public abstract Palo obtenerMismoPalo();
    public abstract ArrayList<Palo> obtenerMismoColor();
    public abstract ArrayList<Palo> obtenerOtroColor();
    public abstract boolean igualPalo(Palo palo);
    public abstract boolean esIgual(Diamante otroPalo);
    public abstract boolean esIgual(Pica otroPalo);
    public abstract boolean esIgual(Trebol otroPalo);
    public abstract boolean esIgual(Corazon otroPalo);
}


/*package Comunes.Palo;

public enum Palo {
    Pica,
    Corazon,
    Trebol,
    Diamante,
}*/