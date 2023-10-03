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

public class ColorIntercaladoDescendenteTest extends TestCase {

    public void testSiguienteQueCumple() {
        Movimiento mov = new ColorIntercaladoDescendente();
        Carta cartaSig  = new Carta(Numero.Siete, new Diamante());
        assert mov.esSiguiente(new Pica(), Numero.Ocho, cartaSig);
    }

    public void testSiguienteQueCumpleDos() {
        Movimiento mov = new ColorIntercaladoDescendente();
        Carta cartaSig  = new Carta(Numero.J, new Trebol());
        assert mov.esSiguiente(new Corazon(), Numero.Q, cartaSig);
    }

    public void testSiguienteQueNoCumplePorPalo() {
        Movimiento mov = new ColorIntercaladoDescendente();
        Carta cartaSig  = new Carta(Numero.J, new Diamante());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.Q, cartaSig));
    }

    public void testSiguienteQueNoCumplePorNumero() {
        Movimiento mov = new ColorIntercaladoDescendente();
        Carta cartaSig  = new Carta(Numero.Q, new Trebol());
        assertFalse(mov.esSiguiente(new Corazon(), Numero.Q, cartaSig));
    }

    //No testeamos los movimientos a Mazo porque los consideramos todos válidos
    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new ColorIntercaladoDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Cuatro, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Tres, new Pica());
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
        Movimiento movimientoATestear = new ColorIntercaladoDescendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Seis, new Corazon());
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Cinco, new Trebol());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.Diez, new Pica());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }

    public void testMoverEsInvalidoPorNoPoderSacarLasCartas(){
        Movimiento movimientoATestear = new ColorIntercaladoDescendente();
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
        carta = new Carta(Numero.Q, new Trebol());
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.Dos, new Pica());
        cartasDestino.add(carta);
        carta = new Carta(Numero.As, new Pica());
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }
}