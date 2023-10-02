package Comunes.Carta;

import Comunes.Palo.Palo;
import Movimientos.Movimiento;

public class Carta {

    private CartaState state;
    private Carta siguiente;
    private final Numero numero;
    private final Palo palo;

    public Carta(Numero numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.state = new CartaBocaAbajoState(this);
    }

    public Carta(Numero numero, Palo palo, CartaState estado){
        this.numero = numero;
        this.palo = palo;
        this.state = estado;
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

    public void cambiarState(CartaState newState) {
        this.state = newState;
    }

    public void ultimaPilon() {
        this.state.ultimaPilon();
    }

    public void traerAlMazo() {
        this.state.traerAlMazo();
    }

    public boolean esSiguiente(Carta cartaChequear, Movimiento movimiento) {
        return movimiento.esSiguiente(this.palo, this.numero, cartaChequear);
    }
    public void pedirAlMazo() {this.state.traerAlMazo(); }


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
