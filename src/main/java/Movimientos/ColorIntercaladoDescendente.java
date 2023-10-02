package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.CartaBocaArribaState;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

import java.util.ArrayList;

public class ColorIntercaladoDescendente implements Movimiento{

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        Carta cartaOrigen = pilonOrigen.getCarta(altura);
        Carta cartaDestino = pilonDestino.getUltimaCarta();

        if(cartaDestino.esSiguiente(cartaOrigen, this))
            pilonDestino.recibirCarta(pilonOrigen.sacarCarta(altura));

    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear) {
        ArrayList<Carta> siguientes = new ArrayList<>();

        if(numero == Numero.As)
            return false;

        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal - 1];

        ArrayList<Palo> palosPosibles = palo.obtenerOtroColor();
        for (Palo paloPosible:
             palosPosibles) {
            Carta siguiente = new Carta(numeroSiguiente, paloPosible);
            siguiente.cambiarState(new CartaBocaArribaState(siguiente));
            siguientes.add(siguiente);
        }

        for(Carta posibleSiguiente : siguientes){
            if(posibleSiguiente.equals(cartaChequear))
                return true;
        }

        return false;
    }
}
