package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.*;
import Objetivos.Objetivo;
import Objetivos.PilonEnteroMismoPaloAsc;

import java.util.List;

public class Klondike extends Solitario {

    private final int CANTIDAD_OBJETIVOS = 4;
    private Pilon waste;
    private Objetivo objetivo;

    public Klondike() {
        super();
        this.waste = new Mazo(new MovimientoLibre()); //Esto lo tengo que cambiar por mismo palo asc
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
        /*for(int i = 0; i < CANTIDAD_OBJETIVOS; i++)
            columnasObjetivo.add(new Columna(new MismoPaloAscendente()));*/
    }

    @Override
    public void setJuego() {
        int contador = 0;
        for (Pilon columna : this.tableau) {
            for (int x = 0; x <= contador; x++) {
                columna.recibirCarta(this.mazo.sacarCarta(0)); //TODO EL CERO ACA NO VA
            }
            contador++;
            contador++;
            columna.getUltimaCarta().ultimaPilon();
        }
        this.setJuegoComenzado(true);
        this.setJuegoComenzado(true);
    }

    @Override
    public boolean juegoGanado() {
        return objetivo.cumplido(this.foundation);
    }



    public void moverMazoAWaste() {
        Carta carta = this.mazo.sacarCarta();
        this.movimiento.moverAPilon(carta, this.waste);
    }

    public void rearmarMazo(Carta carta, Pilon pilonDestino) {
        Movimiento movimiento = new MovimientoLibre();
        this.waste.setMovimiento(movimiento);
        this.waste.mover(this.waste.cantidadCartas()-1, this.mazo);
    }

    public void moverWasteAPilon(int colunma) {
        Movimiento movimiento = new ColorIntercaladoDescendente();
        this.waste.setMovimiento(movimiento);
        Pilon columnaDestino = this.tableau.get(colunma);
        this.waste.mover(this.waste.cantidadCartas()-1, columnaDestino);
    }

    public void moverWasteAFoundation(int foundation) {
        Movimiento movimiento = new MismoPaloDescendente();
        this.waste.setMovimiento(movimiento);
        Pilon foundationDestino = this.foundation.get(foundation);
        this.waste.mover(this.waste.cantidadCartas()-1, foundationDestino);
    }

    public void moverPilonAPilon(int columnaOrigen, int altura, int columnaDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon pilonDestino = this.tableau.get(columnaDestino);
        Movimiento movimiento = new ColorIntercaladoDescendente();
        pilonOrigen.setMovimiento(movimiento);
        pilonOrigen.mover(altura, pilonDestino);
    }

    public void moverPilonAFoundation(int columnaOrigen, int altura, int foundationDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        Pilon foundation = this.foundation.get(foundationDestino);
        Movimiento movimiento = new MismoPaloDescendente();
        pilonOrigen.setMovimiento(movimiento);
        pilonOrigen.mover(altura, foundation);
    }

    public void moverFoundationAPilon(int foundationOrigen, int altura,  int columnaDestino) {
        Pilon foundation = this.foundation.get(foundationOrigen);
        Pilon pilonOrigen = this.tableau.get(columnaDestino);
        Movimiento movimiento = new ColorIntercaladoDescendente();
        foundation.setMovimiento(movimiento);
        foundation.mover(altura, pilonOrigen);
    }

}

