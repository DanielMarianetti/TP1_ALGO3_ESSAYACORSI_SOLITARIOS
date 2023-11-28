package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import junit.framework.TestCase;

public class KlondikeTest extends TestCase {

    public void testCrearSolitarioOrdenado() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        Carta cartaEsperada = new Carta(Numero.K, Palo.TREBOL);

        assertEquals(false, s.juegoComenzado);
        assertEquals(false, s.juegoGanado);
        assertEquals(52, s.mazo.cantidadCartas());
        assertTrue(cartaEsperada.equals(s.mazo.getUltimaCarta()));
    }

    public void testCrearSoliratioRandom() {
        Solitario s = new Klondike();
        s.iniciarRandom();

        assertEquals(24, s.mazo.cantidadCartas());
        assertEquals(1, s.tableau.get(0).cantidadCartas());
        assertEquals(2, s.tableau.get(1).cantidadCartas());
        assertEquals(3, s.tableau.get(2).cantidadCartas());
        assertEquals(4, s.tableau.get(3).cantidadCartas());
        assertEquals(5, s.tableau.get(4).cantidadCartas());
        assertEquals(6, s.tableau.get(5).cantidadCartas());
        assertEquals(7, s.tableau.get(6).cantidadCartas());
        assertEquals(true, s.juegoComenzado);

    }

    public void testMoverMazoAWaste() {
        Solitario s = new Klondike();
        s.iniciarRandom();

        s.moverMazoAWaste();

        assertEquals(1, s.waste.cantidadCartas());
        assertEquals(23, s.mazo.cantidadCartas());
    }

    public void testRearmarMazo() {
        Solitario s = new Klondike();
        s.iniciarRandom();

        for (int i = 0; i < 24; i++) {
            s.moverMazoAWaste();
        }
        s.rearmarMazo();

        assertEquals(24, s.mazo.cantidadCartas());
        assertEquals(0, s.waste.cantidadCartas());
    }

    public void testMovimientoLibre() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        Carta cartaEsperadaA = new Carta(Numero.K, Palo.TREBOL);
        Carta cartaEsperadaB = new Carta(Numero.Q, Palo.TREBOL);

        s.movimientoLibre(0);
        s.movimientoLibre(1);

        assertEquals(50, s.mazo.cantidadCartas());
        assertEquals(1, s.tableau.get(0).cantidadCartas());
        assertEquals(1, s.tableau.get(1).cantidadCartas());
        assertTrue(cartaEsperadaA.equals(s.tableau.get(0).getUltimaCarta()));
        assertTrue(cartaEsperadaB.equals(s.tableau.get(1).getUltimaCarta()));
    }

    public void testMovimientoWaste() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        s.setJuegoComenzado(true);
        Carta cartaEsperadaA = new Carta(Numero.K, Palo.TREBOL);
        Carta cartaEsperadaB = new Carta(Numero.AS, Palo.TREBOL);

        s.moverMazoAWaste();
        s.moverWasteAPilon(0);
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverMazoAWaste();
        s.moverWasteAFoundation(0);

        assertTrue(s.tableau.get(0).getUltimaCarta().equals(cartaEsperadaA));
        assertTrue(s.foundation.get(0).getPrimeraCarta().equals(cartaEsperadaB));
    }

    public  void testMovimientoPilon() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        s.movimientoLibre(0);

        for (int i = 1; i < 12; i++) {
            s.movimientoLibre(1);
        }
        s.movimientoLibre(5);

        for (int i = 0; i < 13; i++) {
            s.movimientoLibre(6);
        }

        for (int i = 0; i < 13; i++) {
            s.movimientoLibre(2);
        }

        for (int i = 0; i < 11; i++) {
            s.movimientoLibre(4);
        }

        s.setJuegoComenzado(true);

        s.moverPilonAPilon(0,0,3);
        s.moverPilonAPilon(2,12,1);
        s.moverPilonAPilon(1, 10, 4);
        s.moverPilonAFoundation(5,0, 0);

        assertEquals(0, s.tableau.get(0).cantidadCartas());
        assertEquals(10, s.tableau.get(1).cantidadCartas());
        assertEquals(12, s.tableau.get(2).cantidadCartas());
        assertEquals(1, s.tableau.get(3).cantidadCartas());
        assertEquals(13, s.tableau.get(4).cantidadCartas());
        assertEquals(1, s.foundation.get(0).cantidadCartas());

    }

    public void testMovimientoFoundation() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();

        for (int i = 0; i < 13; i++) {
            s.movimientoLibre(0);
        }
        for (int i = 0; i < 13; i++) {
            s.movimientoLibre(1);
        }
        for (int i = 0; i < 12; i++) {
            s.movimientoLibre(2);
        }
        s.setJuegoComenzado(true);

        s.moverPilonAFoundation(0, 12, 0);
        s.moverFoundationAPilon(0, 0, 2);

        assertEquals(12, s.tableau.get(0).cantidadCartas());
        assertEquals(13, s.tableau.get(2).cantidadCartas());
        assertEquals(0, s.foundation.get(0).cantidadCartas());
    }

    public  void testJuegoGanado() {
        Solitario s = new Klondike();
        s.iniciarOrdenado();

        for (int x = 0; x < 4; x++) {
            for (int i = 0; i < 13; i++) {
                s.movimientoLibre(x);
            }
        }
        s.setJuegoComenzado(true);

        for (int x = 0; x < 4; x++) {
            for (int i = 0; i < 13; i++) {
                s.moverPilonAFoundation(x, s.tableau.get(x).cantidadCartas()-1, x);
            }
        }

        assertTrue(s.juegoGanado);
    }

}