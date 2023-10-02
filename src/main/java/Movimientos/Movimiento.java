package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

public interface Movimiento {

     void moverAPilon(Carta cartaOrigen, Pilon pilonDestino);
     boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear);
}
