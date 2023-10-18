package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

import java.util.List;

public class MismoPaloAscendente implements Movimiento{

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        List<Carta> cartasOrigen = pilonOrigen.sacarPilon(altura);

        if (cartasOrigen == null) {
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

    @Override
    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear){
        if (cartaChequear == null & numero == Numero.AS) {
            return true;
        } else if (cartaChequear == null & numero != Numero.AS) {
            return false;
        }

        Numero numeroSiguiente = Numero.values()[numero.ordinal() - 1];
        Carta cartaSiguiente = new Carta(numeroSiguiente, palo, true);
        return cartaSiguiente.equals(cartaChequear);
    }
}
