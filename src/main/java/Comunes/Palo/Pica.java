package Comunes.Palo;

import java.util.ArrayList;

public class Pica extends Palo {

    public Palo obtenerMismoPalo(){
        return new Pica();
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
}
