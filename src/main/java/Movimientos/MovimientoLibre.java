package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;

// Movimientos de todos los solitarios antes que el juego empiece para poder poner cartas en cualquier lugar
public class MovimientoLibre implements Movimiento {
    @Override
    public void moverAPilon(Carta cartaOrigen, Pilon pilonDestino) {
        pilonDestino.recibirCarta(cartaOrigen);
    }
}
