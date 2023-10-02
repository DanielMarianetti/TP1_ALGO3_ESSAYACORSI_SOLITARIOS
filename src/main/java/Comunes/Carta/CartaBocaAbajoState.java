package Comunes.Carta;

public class CartaBocaAbajoState implements CartaState {

    Carta carta;

    public boolean tomar(){
        return false;
    }

    public CartaBocaAbajoState(Carta carta) {
        this.carta = carta;
    }

    @Override
    public void pedirDelMazo() {
        this.carta.cambiarState(new CartaBocaArribaState(this.carta));
    }

    @Override
    public void ultimaPilon() {
        this.carta.cambiarState(new CartaBocaArribaState(this.carta));
    }

    @Override
    public void traerAlMazo() {
    }
}
