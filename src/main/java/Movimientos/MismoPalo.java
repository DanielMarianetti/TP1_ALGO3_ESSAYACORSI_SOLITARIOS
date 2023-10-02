package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

public class MismoPalo implements Movimiento {

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        boolean ordenAscendente = false;
        boolean mismoPalo = false;
        // talvez habria que chequear que la altura sea la de la ultima carta del pilon creo

        //tambien cambiar estado de la ultima cargta a ultima del pilon


        Carta cartaOrigen = pilonOrigen.getCarta(altura);
        Carta cartaDestino = pilonDestino.getUltimaCarta();

        Enum<Numero> numOrigen = cartaOrigen.getNumero();

        if (cartaDestino == null && numOrigen.ordinal() == 0) {
            pilonDestino.recibirCarta(pilonOrigen.sacarCarta(altura));
        } else {
            Enum<Palo> paloOrigen = cartaOrigen.getPalo();
            Enum<Palo> paloDestino = cartaDestino.getPalo();
            Enum<Numero> numDestino = cartaDestino.getNumero();

            if (numOrigen.ordinal() == numDestino.ordinal()+1) { ordenAscendente = true; }
            if (paloDestino == paloOrigen) {mismoPalo = true;}

            if (ordenAscendente && mismoPalo) {
                pilonDestino.recibirCarta(pilonOrigen.sacarCarta(altura));
            }
        }
    }
}
