package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

public class SpiderTest extends TestCase {

    public void testCrearSolitarioOrdenado() {
        Solitario s = new Spider();
        s.iniciarOrdenado();
        Carta cartaEsperada = new Carta(Numero.K, Palo.PICA);

        assertFalse(s.juegoComenzado);
        assertFalse(s.juegoGanado);
        assertEquals(104, s.mazo.cantidadCartas());
        assertTrue(cartaEsperada.equals(s.mazo.getUltimaCarta()));
    }

    public void testCrearSoliratioRandom() {
        Solitario s = new Spider();
        s.iniciarRandom();

        assertEquals(50, s.mazo.cantidadCartas());
        assertEquals(6, s.tableau.get(0).cantidadCartas());
        assertEquals(6, s.tableau.get(1).cantidadCartas());
        assertEquals(6, s.tableau.get(2).cantidadCartas());
        assertEquals(6, s.tableau.get(3).cantidadCartas());
        assertEquals(5, s.tableau.get(4).cantidadCartas());
        assertEquals(5, s.tableau.get(5).cantidadCartas());
        assertEquals(5, s.tableau.get(6).cantidadCartas());
        assertEquals(5, s.tableau.get(7).cantidadCartas());
        assertEquals(5, s.tableau.get(8).cantidadCartas());
        assertEquals(5, s.tableau.get(9).cantidadCartas());
        assertTrue(s.juegoComenzado);

    }

    public void testMovimientoLibre() {
        Solitario s = new Spider();
        s.iniciarOrdenado();
        Carta cartaEsperadaA = new Carta(Numero.K, Palo.PICA);
        Carta cartaEsperadaB = new Carta(Numero.Q, Palo.PICA);

        s.movimientoLibre(0);
        s.movimientoLibre(1);

        assertEquals(102, s.mazo.cantidadCartas());
        assertEquals(1, s.tableau.get(0).cantidadCartas());
        assertEquals(1, s.tableau.get(1).cantidadCartas());
        assertTrue(cartaEsperadaA.equals(s.tableau.get(0).getUltimaCarta()));
        assertTrue(cartaEsperadaB.equals(s.tableau.get(1).getUltimaCarta()));
    }

    public  void testMovimientoPilon() {
        Solitario s = new Spider();
        s.iniciarOrdenado();

        for (int i = 0; i < 12; i++) {
            s.movimientoLibre(0);
        }
        s.movimientoLibre(9);

        for (int i = 0; i < 9; i++) {
            s.movimientoLibre(1);
        }

        s.setJuegoComenzado(true);

        s.moverPilonAPilon(0, 9, 1);
        s.moverPilonAPilon(0,0,3);

        assertEquals(0, s.tableau.get(0).cantidadCartas());
        assertEquals(12, s.tableau.get(1).cantidadCartas());
        assertEquals(9, s.tableau.get(3).cantidadCartas());
        assertEquals(1, s.tableau.get(9).cantidadCartas());
    }

    public  void testJuegoGanado() {
        Solitario s = new Spider();
        s.iniciarOrdenado();

        for (int x = 0; x < 8; x++) {
            for (int i = 0; i < 13; i++) {
                s.movimientoLibre(x);
            }
        }
        s.setJuegoComenzado(true);

        for (int i = 0; i < 8; i++) {
            s.moverPilonAPilon(i, 0, 9);
        }

        assertTrue(s.juegoGanado);
    }

}