package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Pilon.Pilon;

public interface Movimiento {

    public void mover(int altura,Pilon pilonOrigen, Pilon pilonDestino);

}
