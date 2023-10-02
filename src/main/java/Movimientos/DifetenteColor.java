package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;

public class DifetenteColor implements Movimiento {
    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        boolean ordenAscendente = false;
        boolean distintoColor = false;

        Carta cartaOrigen = pilonOrigen.getCarta(altura);
        Carta cartaDestino = pilonDestino.getUltimaCarta();

        Enum<Numero> numOrigen = cartaOrigen.getNumero();

        if (cartaDestino == null && numOrigen.ordinal() == 12) {
            pilonDestino.recibirCarta(pilonOrigen.sacarCarta(altura));

        } else {
            Enum<Palo> paloOrigen = cartaOrigen.getPalo();
            Enum<Palo> paloDestino = cartaDestino.getPalo();
            Enum<Numero> numDestino = cartaDestino.getNumero();

            if ((numOrigen.ordinal() == numDestino.ordinal()-1) && chequearOrden(altura,pilonOrigen, pilonDestino)) {
                ordenAscendente = true;
            }


            if (paloDestino.ordinal()%2 != paloOrigen.ordinal()%2) {
                distintoColor = true;
            }

            if (ordenAscendente && distintoColor) {
                for (int i = altura; i < pilonOrigen.getLength(); i++) {
                    pilonDestino.recibirCarta(pilonOrigen.sacarCarta(i));
                }
            }
        }
    }

    private boolean chequearOrden(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        boolean chequeo = false;

        for (int i = altura; i < pilonOrigen.getLength()-1; i++) {
            Carta cartaSup = pilonOrigen.getCarta(i);
            Carta cartaInf = pilonOrigen.getCarta(i+1);

            Enum<Numero> numSup = cartaSup.getNumero();
            Enum<Numero> numInf = cartaInf.getNumero();

            chequeo = numSup.ordinal() == numInf.ordinal()+1;
        }
        return chequeo;
    }
}
