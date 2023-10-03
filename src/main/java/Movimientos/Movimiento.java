package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

//TODO esto deberia ser una clase abstracta, ya que mover es un comportamiento comun para todos
public interface Movimiento {

    void mover(int altura,Pilon pilonOrigen, Pilon pilonDestino);
    boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear);

}
