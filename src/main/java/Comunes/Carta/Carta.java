package Comunes.Carta;

import Movimientos.Movimiento;

public class Carta {

    private Numero numero;

    private Palo palo;

    public Carta(Numero numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
    }

    public boolean equals(Carta otraCarta){
        return otraCarta.equals(this.palo, this.numero);
    }

    public boolean equals(Palo otroPalo, Numero otroNumero){
        boolean esIgual = true;
        if(this.palo != otroPalo)
            esIgual = false;
        if(this.numero != otroNumero)
            esIgual = false;
        return esIgual;
    }


    public boolean colocarSobre(Carta carta, Movimiento movimiento){
        return true;
    }
}
