package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Corazon;
import Comunes.Palo.Diamante;
import Comunes.Palo.Pica;
import Comunes.Palo.Trebol;
import Comunes.Pilon.Columna;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MismoPaloDescendenteTest extends TestCase {
    public void testSiguienteQueCumple() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.Siete, new Trebol());
        assert mov.esSiguiente(new Trebol(), Numero.Ocho, cartaSig);
    }

    public void testSiguienteQueCumpleDos() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.J, new Pica());
        assert mov.esSiguiente(new Pica(), Numero.Q, cartaSig);
    }

    public void testSiguienteQueNoCumplePorPalo() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.K, new Diamante());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.Q, cartaSig));
    }

    public void testSiguienteQueNoCumplePorNumero() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.As, new Corazon());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.As, cartaSig));
    }

    //No testeamos los movimientos a Mazo porque los consideramos todos válidos
    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Cuatro, new Trebol());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Tres, new Trebol());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.Cinco, new Trebol());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 2);
        assertEquals(pilonDestino.cantidadCartas(), 4);
    }

    public void testMoverEsInvalidoPorDestinoQueNoAcepta(){
        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Diamante());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Cinco, new Diamante());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.Cuatro, new Diamante());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }

    public void testMoverEsInvalidoPorNoPoderSacarLasCartas(){
        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Cinco, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Diez, new Corazon());
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