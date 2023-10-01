package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;
import Movimientos.Movimiento;
import Movimientos.MovimientoKlondike;

public class Klondike extends Solitario {

    public Pilon waste;
    public Movimiento movimiento;

    public Klondike() {
        super();
        Movimiento movimiento = new MovimientoKlondike();
        this.waste = new Pilon();
    }

    @Override
    public void setJuego() {
        this.juegoComenzado = true;
        for (int i = 0; i < 7; i++) {
            Pilon columna = new Pilon();
            for (int x = 0; x <= i; x++) {
                columna.recibirCarta(this.mazo.sacarCarta());
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
