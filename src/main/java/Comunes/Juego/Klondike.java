package Comunes.Juego;

import Comunes.Pilon.Columna;
import Comunes.Pilon.Pilon;
import Movimientos.*;
import Objetivos.Objetivo;
import Objetivos.PilonEnteroMismoPaloAsc;

public class Klondike extends Solitario {

    private final int CANTIDAD_OBJETIVOS = 4;

    private Objetivo objetivo;

    public Klondike() {
        super();
        this.objetivo = new PilonEnteroMismoPaloAsc();

        Movimiento movimiento = new ColorIntercaladoDescendente();
        for (int i = 0; i < 7; i++) {
            Pilon columna = new Columna(movimiento);
            this.tableau.add(columna);
        }

        movimiento = new MismoPaloAscendente();
        for (int i = 0; i < CANTIDAD_OBJETIVOS; i++) {
            Pilon columna = new Columna(movimiento);
            this.foundation.add(columna);
        }

    }

    @Override
    public void setJuego() {

        int contador = 0;
        for (Pilon columna : this.tableau) {
            for (int x = 0; x <= contador; x++) {
                columna.recibirCartas(this.mazo.sacarPilon(this.mazo.cantidadCartas()-1));
            }
            contador++;
        }
        this.setJuegoComenzado(true);
    }

    @Override
    public boolean juegoGanado() {
        this.juegoGanado = this.objetivo.cumplido(this.foundation);
        return this.juegoGanado;
    }

    public void moverMazoAWaste() {
        this.mazo.mover(this.mazo.cantidadCartas()-1, this.waste);
        this.waste.getUltimaCarta().setBocaArriba(true);
    }

    public void rearmarMazo() {
        this.waste.setMovimiento(new MovimientoLibre());
        while (!this.waste.isPilonVacio()) {
            this.waste.mover(this.waste.cantidadCartas()-1, this.mazo);
            this.mazo.getUltimaCarta().setBocaArriba(false);
        }
    }

    public void moverWasteAPilon(int colunma) {
        this.waste.setMovimiento(new ColorIntercaladoDescendente());
        Pilon columnaDestino = this.tableau.get(colunma);
        this.waste.mover(this.waste.cantidadCartas()-1, columnaDestino);
    }

    public void moverWasteAFoundation(int foundation) {
        this.waste.setMovimiento(new MismoPaloAscendente());
        Pilon foundationDestino = this.foundation.get(foundation);
        this.waste.mover(this.waste.cantidadCartas()-1, foundationDestino);
        juegoGanado();
    }

    public void moverPilonAPilon(int columnaOrigen, int altura, int columnaDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon pilonDestino = this.tableau.get(columnaDestino);
        pilonOrigen.setMovimiento(new ColorIntercaladoDescendente());
        pilonOrigen.mover(altura, pilonDestino);
        if (!pilonOrigen.isPilonVacio()) {
            pilonOrigen.getUltimaCarta().setBocaArriba(true);
        }
    }

    public void moverPilonAFoundation(int columnaOrigen, int altura, int foundationDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon foundation = this.foundation.get(foundationDestino);
        pilonOrigen.setMovimiento(new MismoPaloAscendente());
        pilonOrigen.mover(altura, foundation);
        juegoGanado();
        if (!pilonOrigen.isPilonVacio()) {
            pilonOrigen.getUltimaCarta().setBocaArriba(true);
        }
    }

    public void moverFoundationAPilon(int foundationOrigen, int altura,  int columnaDestino) {
        if (juegoGanado()) {
            return;
        }
        Pilon foundation = this.foundation.get(foundationOrigen);
        Pilon pilonOrigen = this.tableau.get(columnaDestino);
        foundation.setMovimiento(new ColorIntercaladoDescendente());
        foundation.mover(altura, pilonOrigen);
    }

}