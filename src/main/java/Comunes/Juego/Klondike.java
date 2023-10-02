package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.Movimiento;

public class Klondike extends Solitario {

    public Pilon waste;

    public Klondike() {
        super();
        Movimiento movimiento;

        this.waste = new Mazo();
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

    public void moverMazoAWaste() {
        Carta carta = this.mazo.sacarCarta();
        this.movimiento.moverAPilon(carta, this.waste);
    }

    public void rearmarMazo(Carta carta, Pilon pilonDestino) {

    }

    public void moverWasteAPilon() {
    }

    public void moverPilonAPilon() {

    }

    public void moverAFoundation() {

    }
}
