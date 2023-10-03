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

public class MovimientoLibreTest extends TestCase {
    public void testMovimientoLibreCumpleUno() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.Nueve, new Pica());
        assert mov.esSiguiente(new Diamante(), Numero.As, carta);
    }

    public void testMovimientoLibreCumpleDos() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.Siete, new Trebol());
        assert mov.esSiguiente(new Corazon(), Numero.Dos, carta);
    }

    public void testMovimientoLibreCumpleTres() {
        Movimiento mov = new MovimientoLibre();
        Carta carta  = new Carta(Numero.Ocho, new Diamante());
        assert mov.esSiguiente(new Corazon(), Numero.Ocho, carta);
    }

    //No testeamos los movimientos a Mazo porque los consideramos todos válidos
    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MovimientoLibre();
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
        carta = new Carta(Numero.Cinco, new Corazon());
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

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, new Trebol());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Corazon());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Seis, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.Seis, new Trebol());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(0, pilonOrigen, pilonDestino);

        assertTrue(pilonOrigen.isPilonVacio());
        assertEquals(pilonDestino.cantidadCartas(), 6);
    }
}