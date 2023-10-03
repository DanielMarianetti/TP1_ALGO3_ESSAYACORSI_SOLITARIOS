package Comunes.Palo;

import java.util.ArrayList;

public class Diamante extends Palo {
    private String nombre = "Diamante";
    public Palo obtenerMismoPalo(){
        return new Diamante();
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

    public String getNombre() {
        return nombre;
    }
}
