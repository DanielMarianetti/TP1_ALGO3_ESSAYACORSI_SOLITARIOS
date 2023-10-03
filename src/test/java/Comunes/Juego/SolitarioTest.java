package Comunes.Juego;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Trebol;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

public class SolitarioTest extends TestCase {

    public void testSolitarioEnEstadoRandomInicial() {

        //Arrange
        Solitario s = new Klondike();
        s.IniciarRandom();
        int tamanoEsperado1 = 1;
        int tamanoEsperado2 = 2;
        int tamanoEsperado3 = 3;
        int tamanoEsperado4 = 4;
        int tamanoEsperado5 = 5;
        int tamanoEsperado6 = 6;
        int tamanoEsperado7 = 7;

        //Act
        int tamResultado1 = s.tableau.get(0).cantidadCartas();
        int tamResultado2 = s.tableau.get(1).cantidadCartas();
        int tamResultado3 = s.tableau.get(2).cantidadCartas();
        int tamResultado4 = s.tableau.get(3).cantidadCartas();
        int tamResultado5 = s.tableau.get(4).cantidadCartas();
        int tamResultado6 = s.tableau.get(5).cantidadCartas();
        int tamResultado7 = s.tableau.get(6).cantidadCartas();

        //Assert
        assertEquals(tamanoEsperado1, tamResultado1);
        assertEquals(tamanoEsperado2, tamResultado2);
        assertEquals(tamanoEsperado3, tamResultado3);
        assertEquals(tamanoEsperado4, tamResultado4);
        assertEquals(tamanoEsperado5, tamResultado5);
        assertEquals(tamanoEsperado6, tamResultado6);
        assertEquals(tamanoEsperado7, tamResultado7);
        assertTrue(s.juegoComenzado);
        assertFalse(s.juegoGanado());
    }

    public void testSolitarioEnEstadoEspecificoInicial() {
        //Arrange
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        Carta cartaEsperada = new Carta(Numero.K, new Trebol());

        //Act
        s.movimientoLibre(0);
        s.setJuegoComenzado(true);
        //Assert
        assertEquals(cartaEsperada.getPalo().getNombre(), s.tableau.get(0).getUltimaCarta().getPalo().getNombre());
        assertEquals(cartaEsperada.getNumero().ordinal(), s.tableau.get(0).getUltimaCarta().getNumero().ordinal());
        assertTrue(s.juegoComenzado);
        assertFalse(s.juegoGanado());
    }

    public void testMovimiento() {
        //Arrange
        Solitario s = new Klondike();
        s.iniciarOrdenado();
        s.setJuegoComenzado(true);
        Carta cartaEsperada = new Carta(Numero.K, new Trebol());

        //Act
        s.moverMazoAWaste();

        //Assert
        assertEquals(1, s.waste.cantidadCartas());
        //assertEquals(cartaEsperada.getPalo().getNombre(), s.waste.getUltimaCarta().getPalo().getNombre());
        //assertEquals(cartaEsperada.getNumero().ordinal(), s.tableau.get(0).getUltimaCarta().getNumero().ordinal());
    }



}