package Comunes.Carta;

import Movimientos.Movimiento;

public class CartaBocaArribaState implements CartaState {

    Carta carta;

    public CartaBocaArribaState(Carta carta) {
        this.carta = carta;
    }

    @Override
    public boolean colocarSobre(Carta otraCarta, Movimiento movimiento) {
        return true;
    }

    @Override
    public void ultimaPilon() {
        return;
    }

    @Override
    public void traerAlMazo() {
        this.carta.cambiarState(new CartaBocaAbajoState(this.carta));
    }
}
