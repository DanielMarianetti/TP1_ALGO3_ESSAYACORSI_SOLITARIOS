package Comunes.Juego;

import Comunes.Pilon.Columna;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Solitario {

    public List<Pilon> tableau;
    public Pilon mazo;
    public List<Pilon> foundation;
    public boolean juegoComenzado = false;

    /*public Solitario() {
        this.tableau = new ArrayList<>();
        this.foundation = new ArrayList<>();
        Movimiento movimiento = new DifetenteColor();
        for (int i = 0; i < 7; i++) {
            Pilon columna = new Columna(movimiento);
            this.tableau.add(columna);
        }
        movimiento = new MismoPalo();
        for (int i = 0; i < 4; i++) {
            Pilon columna = new Columna(movimiento);
            this.tableau.add(columna);
        }
    }*/

    ///Crea un juego random
    public void IniciarRandom() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new Mazo(false, movimiento);
        this.setJuego();
        this.setJuegoComenzado(true);
    }

    //Prepara cuantas cartas van a cada pila, depende de cada solitario
    public abstract void setJuego();

    ///Deja el juego listo para empezar a ser jugado a partir de un mazo ordenado
    public void iniciarOrdenado() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new Mazo(true, movimiento);
    }

    //Cambia el estado a comenzado para que no se puedan hacer mas moviminetos libres
    //Solo se pueden hacer los movimientos que dependen del tipo de solitario
    public void setJuegoComenzado(boolean juegoComenzado) {
        if (juegoComenzado) {
            for (Pilon columna : this.tableau) {
                columna.getUltimaCarta().ultimaPilon();
            }
        }
        this.juegoComenzado = juegoComenzado;
    }

    //El objetivo a completar depende del tipo de solitario
    public abstract boolean juegoGanado();

}