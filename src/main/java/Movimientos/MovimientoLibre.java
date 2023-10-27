package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

import java.io.Serializable;

// Movimientos de todos los solitarios antes que el juego empiece para poder poner cartas en cualquier lugar
public class MovimientoLibre implements Movimiento, Serializable {
    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        pilonDestino.recibirCartas(pilonOrigen.sacarPilon(altura));
    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear) {
        return true;
    }
}
