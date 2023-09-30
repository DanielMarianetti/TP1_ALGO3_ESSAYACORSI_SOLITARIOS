package Comunes.Carta;

import Movimientos.Movimiento;

public class CartaBocaAbajoState implements CartaState {

    Carta carta;

    public CartaBocaAbajoState(Carta carta) {
        this.carta = carta;
    }

    @Override
    public boolean colocarSobre(Carta otraCarta, Movimiento movimiento) {
        return false;
    }

    @Override
    public void ultimaPilon() {
        this.carta.cambiarState(new CartaBocaArribaState(this.carta));
    }

    @Override
    public void traerAlMazo() {
        return;
    }
}
