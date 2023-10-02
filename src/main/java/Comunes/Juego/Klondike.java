package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;
import Movimientos.Movimiento;
import Movimientos.PaloIntercaladoDescendente;
import Objetivos.Objetivo;

import java.util.List;

public class Klondike extends Solitario {

    public Pilon waste;
    public Pilon mazo;
    public List<Pilon> objetivos;
    public Movimiento movimiento;
    private Objetivo objetivo;

    public Klondike() {
        super();
        Movimiento movimiento = new PaloIntercaladoDescendente();
        this.waste = new Pilon();
        this.mazo = new Pilon();
    }

    @Override
    public void setJuego() {
        this.juegoComenzado = true;
        for (int i = 0; i < 7; i++) {
            Pilon columna = new Pilon();
            for (int x = 0; x <= i; x++) {
                columna.agregar(this.mazo.sacarCarta());
            }
            columna.getUltimaCarta().ultimaPilon();
        }
    }

    @Override
    public boolean juegoGanado() {
        return false;
    }

    public void mover(int numColumna, int indice, int columnaDestino) {
        Pilon columnaOrigen = this.tableau.get(numColumna);
        Carta cartaOrigen = columnaOrigen.getCarta(indice);
        Pilon columnaDest = this.tableau.get(columnaDestino);
        this.movimiento.moverAPilon(cartaOrigen, columnaDest);
    }

}
