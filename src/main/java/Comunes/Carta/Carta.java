package Comunes.Carta;

import Movimientos.Movimiento;

public class Carta {

    private CartaState state;

    private final Numero numero;

    private final Palo palo;

    public Carta(Numero numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.state = new CartaBocaAbajoState(this);
    }

    public boolean equals(Carta otraCarta){
        return otraCarta.equals(this.palo, this.numero);
    }

    public boolean equals(Palo otroPalo, Numero otroNumero){
        boolean esIgual = this.palo == otroPalo;
        if(this.numero != otroNumero)
            esIgual = false;
        return esIgual;
    }

    public void ultimaPilon() {
        this.state.ultimaPilon();
    }

    public void cambiarState(CartaState newState) {
        this.state = newState;
    }

    public void traerAlMazo() {
        this.state.traerAlMazo();
    }

    public boolean cheaquearSiguiente(Carta carta) {
        return carta.getNumero().ordinal() == this.numero.ordinal();
    }

    public CartaState getState() {
        return state;
    }

    public Numero getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }
}
