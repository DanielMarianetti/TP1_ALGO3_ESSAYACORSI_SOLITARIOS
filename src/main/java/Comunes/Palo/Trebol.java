package Comunes.Palo;

import java.util.ArrayList;

public class Trebol extends Palo {
    private String nombre = "Trebol";
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

    public String getNombre() {
        return nombre;
    }
}
