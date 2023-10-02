package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.Movimiento;
import Movimientos.MovimientoLibre;

import java.util.ArrayList;
import java.util.List;

public abstract class Solitario {

    public List<Pilon> tableau;
    public Pilon mazo;
    public boolean juegoComenzado = false;
    public Movimiento movimientolibre;

    public Solitario() {
        this.tableau = new ArrayList<>();
        this.movimientolibre = new MovimientoLibre();
    }

    ///Crea un juego random
    public void IniciarRandom() {
        this.mazo = new Mazo(false);
        this.setJuego();
        this.setJuegoComenzado(true);
    }

    //Prepara cuantas cartas van a cada pila, depende de cada solitario
    public abstract void setJuego();

    ///Deja el juego listo para empezar a ser jugado a partir de un mazo ordenado
    public void iniciarOrdenado() {
        this.mazo = new Mazo(true);
    }

    //Mueve cartas a lugares sin reglas del solitario
    public void moverLibre(int columna) {
        if (!this.juegoComenzado) {
            Carta carta = this.mazo.sacarCarta();
            this.movimientolibre.moverAPilon(carta, this.tableau.get(columna));
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
/*

Cartas: Mostrables ¿Movibles?

Pilones:
    Conjunto de cartas
    Mover:
        Pilon (carta)-> Pilon
            Un strategy al construir el juego que determine el algoritmo a seguir para cada pilón al
            momento de querer recibir una carta o un pilón
    Puede solo recibir, o solo dar, o ambas
        Lo implemento con delegacion simple

Inicializar juego a partir de una semilla:
    Genero cartas y las pongo en x pilones, x cantidad

Ganar:
    A partir de un strategy puedo pasarle al juego un algoritmo para determinar la forma en que se gana,
    cada juego conoce este algoritmo y le pasa a los pilones correspondientes el chequeo a realizar

* */