package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

public interface Movimiento {

    void mover(int altura,Pilon pilonOrigen, Pilon pilonDestino);

    boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear);

}
