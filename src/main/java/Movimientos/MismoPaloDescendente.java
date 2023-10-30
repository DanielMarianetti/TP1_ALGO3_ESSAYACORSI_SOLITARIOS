package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

import java.util.List;

public class MismoPaloDescendente implements Movimiento {

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        List<Carta> cartasOrigen = pilonOrigen.sacarPilon(altura);

        if (cartasOrigen == null) {
            return;
        }

        Carta cartaDestino = pilonDestino.getUltimaCarta();
        Carta cartaOrigen = cartasOrigen.get(0);

        if (cartaDestino == null) {
            pilonDestino.recibirCartas(cartasOrigen);
        } else if (esSiguiente(cartaDestino.getPalo(), cartaDestino.getNumero(), cartaOrigen)) {
            pilonDestino.recibirCartas(cartasOrigen);
        } else {
            pilonOrigen.recibirCartas(cartasOrigen);
        }
    }

    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaSiguiente) {
        if (numero == Numero.AS) {
            return false;
        }
        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal - 1];
        Carta posibleSiguiente = new Carta(numeroSiguiente, palo);
        return posibleSiguiente.equals(cartaSiguiente);
    }

}
