package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;

public class Klondike extends Solitario {

    public Pilon waste;

    public Klondike() {
        super();
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
