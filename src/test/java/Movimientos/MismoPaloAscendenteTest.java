package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Corazon;
import Comunes.Palo.Diamante;
import Comunes.Palo.Pica;
import Comunes.Palo.Trebol;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MismoPaloAscendenteTest extends TestCase {

    public void testSiguienteQueCumple() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.Nueve, new Trebol());
        assert mov.esSiguiente(new Trebol(), Numero.Ocho, cartaSig);
    }

    public void testSiguienteQueCumpleDos() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.K, new Pica());
        assert mov.esSiguiente(new Pica(), Numero.Q, cartaSig);
    }

    public void testSiguienteQueNoCumplePorPalo() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.J, new Diamante());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.Q, cartaSig));
    }

    public void testSiguienteQueNoCumplePorNumero() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.Q, new Corazon());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.Q, cartaSig));
    }

    //No testeamos los movimientos a Mazo porque los consideramos todos válidos
    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, new Corazon());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.Diez, new Corazon());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 2);
        assertEquals(pilonDestino.cantidadCartas(), 4);
    }

    public void testMoverEsInvalidoPorDestinoQueNoAcepta(){
        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, new Corazon());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.K, new Corazon());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }

    public void testMoverEsInvalidoPorNoPoderSacarLasCartas(){
        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.K, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, new Corazon());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.J, new Corazon());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }
}