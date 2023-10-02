package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

// Movimientos de todos los solitarios antes que el juego empiece para poder poner cartas en cualquier lugar
public class MovimientoLibre implements Movimiento {
    @Override
    public void moverAPilon(Carta cartaOrigen, Pilon pilonDestino) {
        pilonDestino.agregar(cartaOrigen);
    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear) {
        return true;
    }
}
