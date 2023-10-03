package Comunes.Palo;

import java.util.ArrayList;

public class Corazon extends Palo {
    private String nombre = "Corazon";

    public Palo obtenerMismoPalo(){
        return new Corazon();
    }
    public ArrayList<Palo> obtenerMismoColor(){
        ArrayList<Palo> palos = new ArrayList<>();
        palos.add(new Corazon());
        palos.add(new Diamante());
        return palos;
    }
    public ArrayList<Palo> obtenerOtroColor(){
        ArrayList<Palo> palos = new ArrayList<>();
        palos.add(new Pica());
        palos.add(new Trebol());
        return palos;
    }

    public boolean igualPalo(Palo otroPalo) {
        return otroPalo.esIgual(this);
    }

    @Override
    public boolean esIgual(Diamante palo) {
        return false;
    }

    @Override
    public boolean esIgual(Corazon palo) {
        return true;
    }

    @Override
    public boolean esIgual(Pica palo) {
        return false;
    }

    @Override
    public boolean esIgual(Trebol palo) {
        return false;
    }
}
