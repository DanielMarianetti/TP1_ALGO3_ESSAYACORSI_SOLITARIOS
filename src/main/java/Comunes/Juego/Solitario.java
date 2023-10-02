package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.Libre;
import Movimientos.Movimiento;
import Movimientos.MovimientoLibre;

import java.util.ArrayList;
import java.util.List;

public abstract class Solitario {

    public List<Pilon> tableau;
    public Pilon mazo;
    public boolean juegoComenzado = false;

    public Solitario() {
        this.tableau = new ArrayList<>();
    }

    ///Crea un juego random
    public void IniciarRandom() {
        Movimiento movimiento = new Libre();
        this.mazo = new Mazo(false, movimiento);
        this.setJuego();
        this.setJuegoComenzado(true);
    }

    //Prepara cuantas cartas van a cada pila, depende de cada solitario
    public abstract void setJuego();

    ///Deja el juego listo para empezar a ser jugado a partir de un mazo ordenado
    public void iniciarOrdenado() {
        Movimiento movimiento = new Libre();
        this.mazo = new Mazo(true, movimiento);
    }

    //Mueve cartas a lugares sin reglas del solitario
    public  void moverLibre(int columna) {
        // int altura = this.mazo.()-1;                        // chequear si esto de la altura esta bien
        if (!this.juegoComenzado) {
            this.mazo.mover(0, this.tableau.get(columna));
        }
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