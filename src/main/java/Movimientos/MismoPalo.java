package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

public class MismoPalo implements Movimiento {

    //muve
    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        boolean ordenAscendente = false;
        boolean mismoPalo = false;

        Carta cartaOrigen = pilonOrigen.getPrimeraCarta();
        Carta castaDestino = pilonDestino.getCarta(altura);

        Enum<Palo> paloOrigen = cartaOrigen.getPalo();
        Enum<Palo> paloDestino = castaDestino.getPalo();
        Enum<Numero> numOrigen = cartaOrigen.getNumero();
        Enum<Numero> numDestino = castaDestino.getNumero();

        if (numOrigen.ordinal() == numDestino.ordinal()-1) { ordenAscendente = true; }
        if (paloDestino == paloOrigen) {mismoPalo = true;}

        if (ordenAscendente && mismoPalo) {
            // for (i = altura; )
        }
    }
}
