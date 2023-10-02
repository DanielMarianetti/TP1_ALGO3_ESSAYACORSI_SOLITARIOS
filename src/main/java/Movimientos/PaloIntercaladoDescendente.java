package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.CartaBocaArribaState;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

import java.util.ArrayList;

public class PaloIntercaladoDescendente implements Movimiento{

    // mueve ultima carta del pilon a otro pilon si son de color diferente y estan ordenadas
    @Override
    public void moverAPilon(Carta cartaOrigen, Pilon pilonDestino) {

    }

    //mueve todo un pilon de cartas a otro pilon si se cumplen las condiciones
    public void moverAPilon(Pilon pilonOrigen, Pilon pilonDestino) {

    }

    public void moverAFoundation(Carta cartaOrigen, Pilon foundationDestino) {

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
