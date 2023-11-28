package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;

import Comunes.Carta.Palo;
import Comunes.Pilon.Columna;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MovimientoLibreTest extends TestCase {

    public void testMovimientoLibreCumpleUno() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.NUEVE, Palo.TREBOL);
        assert mov.esSiguiente(Palo.TREBOL, Numero.AS, carta);
    }

    public void testMovimientoLibreCumpleDos() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.SIETE, Palo.TREBOL);
        assert mov.esSiguiente(Palo.CORAZON, Numero.DOS, carta);
    }

    public void testMovimientoLibreCumpleTres() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.OCHO, Palo.DIAMANTE);
        assert mov.esSiguiente(Palo.CORAZON, Numero.OCHO, carta);
    }

    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MovimientoLibre();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, Palo.CORAZON, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, Palo.CORAZON, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.CINCO, Palo.CORAZON, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(0, pilonOrigen, pilonDestino);

        assertTrue(pilonOrigen.isPilonVacio());
        assertEquals(pilonDestino.cantidadCartas(), 6);
    }

    public void testMoverValidoDos(){
        Movimiento movimientoATestear = new MovimientoLibre();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, Palo.TREBOL, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.CORAZON, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.SEIS,Palo.TREBOL, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(0, pilonOrigen, pilonDestino);

        assertTrue(pilonOrigen.isPilonVacio());
        assertEquals(pilonDestino.cantidadCartas(), 6);
    }
}