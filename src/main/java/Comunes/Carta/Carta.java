package Comunes.Carta;

import java.io.Serializable;

public class Carta implements Serializable {

    private boolean bocaArriba;
    private final Numero numero;
    private final Palo palo;

    public Carta(Numero numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba = false;
    }

    public Carta(Numero numero, Palo palo, boolean estado){
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba = estado;
    }

    public boolean equals(Carta otraCarta){
        return otraCarta.equals(this.palo, this.numero);
    }

    private boolean equals(Palo otroPalo, Numero otroNumero){
        return this.getPalo() == otroPalo && this.getNumero() == otroNumero;
    }

    public void setBocaArriba(boolean cara) {
        this.bocaArriba = cara;
    }

    public boolean isBocaArriba() {
        return this.bocaArriba;
    }

    public Numero getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

}
