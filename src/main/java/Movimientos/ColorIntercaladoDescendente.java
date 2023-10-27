package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColorIntercaladoDescendente implements Movimiento, Serializable {

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        List<Carta> cartasOrigen = pilonOrigen.sacarPilon(altura);
        if(cartasOrigen == null) {
            return;
        }

        Carta cartaDestino = pilonDestino.getUltimaCarta();
        Carta cartaOrigen = cartasOrigen.get(0);

        if (esSiguiente(cartaOrigen.getPalo(), cartaOrigen.getNumero(), cartaDestino)) {
            pilonDestino.recibirCartas(cartasOrigen);
        } else {
            pilonOrigen.recibirCartas(cartasOrigen);
        }
    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaSiguiente) {
        if ((numero == Numero.K & cartaSiguiente == null)) {
            return true;
        } else if (numero == Numero.K) {
            return false;
        }

        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal + 1];
        String colorSiguiente = palo.color;
        List<Carta> cartasPosibles = new ArrayList<>();

        for (Palo paloPosible : Palo.values()) {
            if (!Objects.equals(paloPosible.color, colorSiguiente)) {
                cartasPosibles.add(new Carta(numeroSiguiente, paloPosible));
            }
        }

        for(Carta posibleSiguiente : cartasPosibles){
            if(posibleSiguiente.equals(cartaSiguiente)) {
                return true;
            }
        }
        return false;

    }
}
