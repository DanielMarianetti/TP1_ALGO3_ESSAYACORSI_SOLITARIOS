package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.CartaBocaArribaState;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

import java.util.ArrayList;

public class MismoPaloDescendente implements Movimiento {

    public void moverAPilon(Carta cartaOrigen, Pilon pilonDestino) {
        pilonDestino.agregar(cartaOrigen);
    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear) {

        if(numero == Numero.As)
            return false;

        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal - 1];

        Carta siguiente = new Carta(numeroSiguiente, palo.obtenerMismoPalo());
        siguiente.cambiarState(new CartaBocaArribaState(siguiente));

        return siguiente.equals(cartaChequear);
    }
}
