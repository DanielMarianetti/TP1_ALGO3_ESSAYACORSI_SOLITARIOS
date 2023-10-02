package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

public interface Movimiento {

     /*void moverAPilon(Carta cartaOrigen, Pilon pilonDestino);
     boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear);*/
    void mover(int altura,Pilon pilonOrigen, Pilon pilonDestino);
    boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear);

}
