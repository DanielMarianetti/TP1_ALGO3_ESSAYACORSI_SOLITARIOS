package Comunes.Juego;

import Comunes.Pilon.Columna;
import Comunes.Pilon.MazoDobleUnPalo;
import Comunes.Pilon.Pilon;
import Movimientos.MismoPaloAscendente;
import Movimientos.MismoPaloDescendente;
import Movimientos.Movimiento;
import Movimientos.MovimientoLibre;
import Objetivos.Objetivo;
import Objetivos.PilonEnteroMismoPaloAsc;
import Objetivos.PilonSecuenciaCompleta;

public class Spider extends Solitario {

    private final int CANTIDAD_OBJETIVOS = 8;

    private Objetivo objetivo;
    private Objetivo sec;
    private int foundationSieguiente = 0;

    public Spider() {
        super();
        this.objetivo = new PilonEnteroMismoPaloAsc();

        Movimiento movimiento = new MismoPaloDescendente();
        for (int i = 0; i < 10; i++) {
            Pilon columna = new Columna(movimiento);
            this.tableau.add(columna);
        }

        movimiento = new MismoPaloAscendente();
        for (int i = 0; i < CANTIDAD_OBJETIVOS; i++) {
            Pilon columna = new Columna(movimiento);
            this.foundation.add(columna);
        }

        this.sec = new PilonSecuenciaCompleta();
    }

    @Override
    public  void iniciarRandom() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new MazoDobleUnPalo(false, movimiento);
        this.setJuego();
        this.setJuegoComenzado(true);
    }

    @Override
    public void iniciarOrdenado() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new MazoDobleUnPalo(true, movimiento);
    }

    @Override
    public void setJuego() {

        int contador = 1;
        for (Pilon columna : this.tableau) {
            for (int x = 0; x < 5; x++) {
                columna.recibirCartas(this.mazo.sacarPilon(this.mazo.cantidadCartas()-1));
            }
            if (contador < 5) {
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
        for (Pilon c : this.tableau) {
            this.mazo.mover(this.mazo.cantidadCartas()-1, c);
            c.getUltimaCarta().setBocaArriba(true);
        }
    }

    public void rearmarMazo() {
        return;
    }

    public void moverWasteAPilon(int colunma) {
        return;
    }

    public void moverWasteAFoundation(int foundation) {
        return;
    }

    public void moverPilonAPilon(int columnaOrigen, int altura, int columnaDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        pilonOrigen.setMovimiento(new MismoPaloDescendente());
        Pilon pilonDestino = this.tableau.get(columnaDestino);
        pilonOrigen.mover(altura, pilonDestino);
        if (!pilonOrigen.isPilonVacio()) {
            pilonOrigen.getUltimaCarta().setBocaArriba(true);
        }
        if (this.sec.cumplido(pilonDestino)) {
            moverPilonAFoundation(columnaDestino, pilonDestino.cantidadCartas()-13, foundationSieguiente);
            foundationSieguiente++;
        }
    }

    public void moverPilonAFoundation(int columnaOrigen, int altura, int foundationDestino) {
        Pilon pilonOrigen = this.tableau.get(columnaOrigen);
        pilonOrigen.setMovimiento(new MovimientoLibre());
        Pilon fDestino = this.foundation.get(foundationDestino);
        pilonOrigen.mover(altura, fDestino);
        if (!pilonOrigen.isPilonVacio()) {
            pilonOrigen.getUltimaCarta().setBocaArriba(true);
        }
        this.juegoGanado();
    }

    public void moverFoundationAPilon(int foundationOrigen, int altura,  int columnaDestino) {
        return;
    }

}
