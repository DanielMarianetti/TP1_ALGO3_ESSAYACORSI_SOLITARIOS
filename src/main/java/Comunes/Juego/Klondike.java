package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.DifetenteColor;
import Movimientos.Libre;
import Movimientos.MismoPalo;
import Movimientos.Movimiento;

public class Klondike extends Solitario {

    public Pilon waste;

    public Klondike() {
        super();
        Movimiento movimiento = new Libre();
        this.waste = new Mazo(movimiento);
    }

    @Override
    public void setJuego() {
        int contador = 0;
        for (Pilon columna : this.tableau) {
            for (int x = 0; x <= contador; x++) {
                columna.recibirCarta(this.mazo.sacarCarta());
            }
            contador++;
            columna.getUltimaCarta().ultimaPilon();
        }
        this.setJuegoComenzado(true);
    }

    @Override
    public boolean juegoGanado() {
        return false;
    }


    public void moverMazoAWaste() {
        this.mazo.mover(this.mazo.getLength()-1, this.waste);
    }

    public void rearmarMazo(Carta carta, Pilon pilonDestino) {
        Movimiento movimiento = new Libre();
        this.waste.setMovimiento(movimiento);
        this.waste.mover(this.waste.getLength()-1, this.mazo);
    }

    public void moverWasteAPilon(int colunma) {
        Movimiento movimiento = new DifetenteColor();
        this.waste.setMovimiento(movimiento);
        Pilon columnaDestino = this.tableau.get(colunma);
        this.waste.mover(this.waste.getLength()-1, columnaDestino);
    }

    public void moverWasteAFoundation(int foundation) {
        Movimiento movimiento = new MismoPalo();
        this.waste.setMovimiento(movimiento);
        Pilon foundationDestino = this.foundation.get(foundation);
        this.waste.mover(this.waste.getLength()-1, foundationDestino);
    }

    public void moverPilonAPilon(int columnaOrigen, int altura, int columnaDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon pilonDestino = this.tableau.get(columnaDestino);
        Movimiento movimiento = new DifetenteColor();
        pilonOrigen.setMovimiento(movimiento);
        pilonOrigen.mover(altura, pilonDestino);
    }

    public void moverPilonAFoundation(int columnaOrigen, int altura, int foundationDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon foundation = this.foundation.get(foundationDestino);
        Movimiento movimiento = new MismoPalo();
        pilonOrigen.setMovimiento(movimiento);
        pilonOrigen.mover(altura, foundation);
    }

    public void moverFoundationAPilon(int foundationOrigen, int altura,  int columnaDestino) {
        Pilon foundation = this.foundation.get(foundationOrigen);
        Pilon pilonOrigen = this.tableau.get(columnaDestino);
        Movimiento movimiento = new DifetenteColor();
        foundation.setMovimiento(movimiento);
        foundation.mover(altura, pilonOrigen);
    }

    public void MoverFoundationAFoundation(int foundationOrigen, int altura, int foundationDestino) {
        Pilon foundationOrg = this.foundation.get(foundationOrigen);
        Pilon foundationDest = this.foundation.get(foundationDestino);
        Movimiento movimiento = new MismoPalo();
        foundationOrg.setMovimiento(movimiento);
        foundationOrg.mover(altura, foundationDest);
    }
}
