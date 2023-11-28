package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Columna;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MismoPaloDescendenteTest extends TestCase {

    public void testSiguienteQueCumple() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.SIETE, Palo.DIAMANTE);
        assert mov.esSiguiente(Palo.DIAMANTE, Numero.OCHO, cartaSig);
    }

    public void testSiguienteQueCumpleDos() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.NUEVE, Palo.TREBOL);
        assert mov.esSiguiente(Palo.TREBOL, Numero.DIEZ, cartaSig);
    }

    public void testSiguienteQueNoCumplePorPalo() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.J, Palo.DIAMANTE);
        assertFalse(mov.esSiguiente(Palo.PICA, Numero.Q, cartaSig));
    }

    public void testSiguienteQueNoCumplePorNumero() {
        Movimiento mov = new MismoPaloDescendente();
        Carta cartaSig  = new Carta(Numero.Q, Palo.TREBOL);
        assertFalse(mov.esSiguiente(Palo.TREBOL, Numero.Q, cartaSig));
    }

    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.TRES, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.CUATRO, Palo.TREBOL, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.CINCO, Palo.TREBOL, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(3, pilonOrigen, pilonDestino);

        assertEquals(3, pilonOrigen.cantidadCartas());
        assertEquals(3, pilonDestino.cantidadCartas());
    }

    public void testMoverEsInvalidoPorDestinoQueNoAcepta(){
        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.CORAZON, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.CINCO, Palo.TREBOL, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.DIEZ, Palo.PICA, true);
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

        Carta carta = new Carta(Numero.DOS, Palo.PICA);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.K, Palo.CORAZON);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, Palo.TREBOL);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA);
        cartasDestino.add(carta);
        carta = new Carta(Numero.AS, Palo.PICA);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(4, pilonOrigen.cantidadCartas());
        assertEquals(2, pilonDestino.cantidadCartas());
    }

    public void testMoverAVacio(){

        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.TRES, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.K, Palo.CORAZON, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        movimientoATestear.mover(3, pilonOrigen, pilonDestino);

        assertEquals(3, pilonOrigen.cantidadCartas());
        assertEquals(1, pilonDestino.cantidadCartas());
    }

    public void testMoverVariasCartas(){

        Movimiento movimientoATestear = new MismoPaloDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.CUATRO, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.TRES, Palo.PICA, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.CINCO, Palo.PICA, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(2, pilonOrigen.cantidadCartas());
        assertEquals(4, pilonDestino.cantidadCartas());
    }
}