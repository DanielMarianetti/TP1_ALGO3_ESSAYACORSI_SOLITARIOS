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

        if ((cartaDestino == null & cartaOrigen.getNumero() == Numero.AS)) {
            pilonDestino.recibirCartas(cartasOrigen);
        } else if (cartaDestino == null || cartasOrigen.size() > 1) {
            pilonOrigen.recibirCartas(cartasOrigen);
        }else if (esSiguiente(cartaDestino.getPalo(), cartaDestino.getNumero(), cartaOrigen)) {
            pilonDestino.recibirCartas(cartasOrigen);
        } else {
            pilonOrigen.recibirCartas(cartasOrigen);
        }
    }

    @Override
    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear){
        if (numero == Numero.K) {
            return false;
        }
        Numero numeroSiguiente = Numero.values()[numero.ordinal() + 1];
        Carta cartaSiguiente = new Carta(numeroSiguiente, palo, true);
        return cartaSiguiente.equals(cartaChequear);
    }
}
