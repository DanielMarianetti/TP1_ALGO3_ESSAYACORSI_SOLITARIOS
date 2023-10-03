package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.CartaBocaArribaState;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

public class MismoPaloDescendente implements Movimiento {

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        Carta cartaOrigen = pilonOrigen.getCarta(altura);
        Carta cartaDestino = pilonDestino.getUltimaCarta();

        if(cartaDestino.esSiguiente(cartaOrigen, this))
            pilonDestino.recibirCartas(pilonOrigen.sacarPilon(altura));

    }

    @Override
    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear){
        if(numero == Numero.As)
            return false;

        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal - 1];

        Carta siguiente = new Carta(numeroSiguiente, palo.obtenerMismoPalo());
        siguiente.cambiarState(new CartaBocaArribaState(siguiente));

        return siguiente.equals(cartaChequear);
    }
}
