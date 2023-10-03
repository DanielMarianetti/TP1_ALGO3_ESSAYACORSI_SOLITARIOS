package Comunes.Palo;

import java.util.ArrayList;

public class Trebol extends Palo {

    public Palo obtenerMismoPalo(){
        return new Trebol();
    }
    public ArrayList<Palo> obtenerMismoColor(){
        ArrayList<Palo> palos = new ArrayList<>();
        palos.add(new Pica());
        palos.add(new Trebol());
        return palos;
    }
    public ArrayList<Palo> obtenerOtroColor(){
        ArrayList<Palo> palos = new ArrayList<>();
        palos.add(new Diamante());
        palos.add(new Corazon());
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
        return false;
    }

    @Override
    public boolean esIgual(Pica palo) {
        return false;
    }

    @Override
    public boolean esIgual(Trebol palo) {
        return true;
    }
}
