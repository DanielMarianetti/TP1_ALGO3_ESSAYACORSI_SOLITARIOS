package Comunes.Carta;

import Movimientos.Movimiento;

public class CartaBocaArribaState implements CartaState {

    Carta carta;

    public boolean tomar(){
        return true;
    }

    public CartaBocaArribaState(Carta carta) {
        this.carta = carta;
    }

    @Override
    public void pedirDelMazo() {
    }

    @Override
    public void ultimaPilon() {
        return;
    }

    @Override
    public void traerAlMazo() {
        this.carta.cambiarState(new CartaBocaAbajoState(this.carta));
    }

    @Override
    public String mostrarEstado() {
        return "Boca Arriba";
    }
}
