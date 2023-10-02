package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;

public class Libre implements Movimiento {
    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        Carta cartaOrigen = pilonOrigen.getCarta(altura);
        pilonDestino.recibirCarta(pilonOrigen.sacarCarta(altura));
    }
}
