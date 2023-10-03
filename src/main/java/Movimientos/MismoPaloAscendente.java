package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.CartaBocaArribaState;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Comunes.Pilon.Pilon;

import java.util.List;

public class MismoPaloAscendente implements Movimiento{

    @Override
    public void mover(int altura, Pilon pilonOrigen, Pilon pilonDestino) {
        List<Carta> cartasOrigen = pilonOrigen.sacarPilon(altura);
        if(cartasOrigen == null)
            return;

        //Debemos devolver las cartas al pilon del que la sacamos en caso que el
        // destino no pueda recibir las cartas
        if(!pilonDestino.recibirCartas(cartasOrigen)){
            Movimiento actual = pilonOrigen.getMovimiento();
            pilonOrigen.setMovimiento(new MovimientoLibre());
            pilonOrigen.recibirCartas(cartasOrigen);
            pilonOrigen.setMovimiento(actual);
        }
    }

    @Override
    public boolean esSiguiente(Palo palo, Numero numero, Carta cartaChequear){
        if(numero == Numero.K)
            return false;

        int ordinal = numero.ordinal();
        Numero numeroSiguiente = Numero.values()[ordinal + 1];

        Carta siguiente = new Carta(numeroSiguiente, palo.obtenerMismoPalo());
        siguiente.cambiarState(new CartaBocaArribaState(siguiente));

        return siguiente.equals(cartaChequear);
    }
}
