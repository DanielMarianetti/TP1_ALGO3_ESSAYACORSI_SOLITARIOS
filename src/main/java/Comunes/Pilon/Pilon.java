package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.Movimiento;

import java.util.List;

public abstract class Pilon {

    public Movimiento movimiento;

    public Pilon(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public abstract void setCartas(List<Carta> cartas);

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public abstract Carta getUltimaCarta();

    public abstract Carta getPrimeraCarta();

    public abstract Carta getCarta(int i);

    public abstract boolean isPilonVacio();

    public abstract int cantidadCartas();

    public void mover(int altura, Pilon pilonDestino){
        this.movimiento.mover(altura,this, pilonDestino);
    }

    public abstract void recibirCartas(List<Carta> cartasAgregar);

    //public abstract void recibirCarta(Carta carta);

    public abstract List<Carta> sacarPilon(int i);

    public abstract boolean cumpleCon(Movimiento movimientoControl, int cantidadSecuencia);
}
