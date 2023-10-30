package Movimientos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Columna;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MismoPaloAscendenteTest extends TestCase {

    public void testSiguienteQueCumple() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.NUEVE, Palo.TREBOL);
        assert mov.esSiguiente(Palo.TREBOL, Numero.OCHO, cartaSig);
    }

    public void testSiguienteQueCumpleDos() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.Q, Palo.PICA);
        assert mov.esSiguiente(Palo.PICA, Numero.J, cartaSig);
    }

    public void testSiguienteQueNoCumplePorPalo() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.Q, Palo.DIAMANTE);
        assertFalse(mov.esSiguiente(Palo.CORAZON, Numero.J, cartaSig));
    }

    public void testSiguienteQueNoCumplePorNumero() {
        Movimiento mov = new MismoPaloAscendente();
        Carta cartaSig  = new Carta(Numero.Q, Palo.CORAZON);
        assertFalse(mov.esSiguiente(Palo.CORAZON, Numero.Q, cartaSig));
    }

    public void testMoverAColumnaValido(){

        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, Palo.CORAZON, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.J, Palo.CORAZON, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.DIEZ, Palo.CORAZON, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        pilonOrigen.mover(3, pilonDestino);

        assertEquals(3, pilonOrigen.cantidadCartas());
        assertEquals(3, pilonDestino.cantidadCartas());
    }

    public void testMoverEsInvalidoPorDestinoQueNoAcepta(){
        Movimiento movimientoATestear = new MismoPaloAscendente();
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
        carta = new Carta(Numero.K, Palo.CORAZON, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(4, pilonOrigen.cantidadCartas());
        assertEquals(2, pilonDestino.cantidadCartas());
    }

    public void testMoverEsInvalidoPorNoPoderSacarLasCartas(){
        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();
        ArrayList<Carta> cartasDestino = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.SEIS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.K, Palo.CORAZON, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.Q, Palo.CORAZON, true);
        cartasOrigen.add(carta);

        pilonOrigen.setCartas(cartasOrigen);

        carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasDestino.add(carta);
        carta = new Carta(Numero.J, Palo.CORAZON, true);
        cartasDestino.add(carta);

        pilonDestino.setCartas(cartasDestino);

        movimientoATestear.mover(2, pilonOrigen, pilonDestino);

        assertEquals(pilonOrigen.cantidadCartas(), 4);
        assertEquals(pilonDestino.cantidadCartas(), 2);
    }

    public void testMoverAPilonVacio() {
        Movimiento movimientoATestear = new MismoPaloAscendente();
        Columna pilonOrigen = new Columna(movimientoATestear);
        Columna pilonDestino = new Columna(movimientoATestear);
        Columna pilonDestino_2 = new Columna(movimientoATestear);

        ArrayList<Carta> cartasOrigen = new ArrayList<>();

        Carta carta = new Carta(Numero.DOS, Palo.PICA, true);
        cartasOrigen.add(carta);
        carta = new Carta(Numero.AS, Palo.PICA, true);
        cartasOrigen.add(carta);
        pilonOrigen.setCartas(cartasOrigen);
        System.out.println(pilonOrigen.cantidadCartas());

        movimientoATestear.mover(1, pilonOrigen, pilonDestino);
        movimientoATestear.mover(0, pilonOrigen, pilonDestino_2);

        assertEquals(pilonOrigen.cantidadCartas(), 1);
        assertEquals(pilonDestino.cantidadCartas(), 1);
        assertEquals(pilonDestino_2.cantidadCartas(), 0);
    }
}