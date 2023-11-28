package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Movimientos.MismoPaloAscendente;
import Movimientos.Movimiento;
import Movimientos.MovimientoLibre;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ColumnaTest extends TestCase {

    public void testCrearPilonVacio() {
        // testeo que el pilon se cree de forma correcta

        //Arrange
        Pilon p = new Columna(new MovimientoLibre());
        int tamanoEsperado = 0;
        boolean vacioEsperado = true;

        //Act
        int tamanoResultado = p.cantidadCartas();
        boolean vacioResultado = p.isPilonVacio();

        //Assert
        assertEquals(tamanoEsperado,tamanoResultado);
        assertEquals(vacioEsperado, vacioResultado);
    }

    public void testCrearPilonConCartas() {
        // testeo que el pilon se cree de forma correcta

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta(Numero.K, Palo.CORAZON);
        for (int i = 0; i < 10; i++) {
            cartas.add(carta);
        }
        Pilon p = new Columna(new MovimientoLibre(), cartas);
        int tamanoEsperado = 10;
        boolean vacioEsperado = false;

        //Act
        int tamanoResultado = p.cantidadCartas();
        boolean vacioResultado = p.isPilonVacio();

        //Assert
        assertEquals(tamanoEsperado,tamanoResultado);
        assertEquals(vacioEsperado, vacioResultado);
    }

    public void testObtenerLaUltimaCartaEsCorrecta() {
        // testeo que la ultima carta del pilon sea la correcta

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        for (int i = 0; i < 10; i++) {
            cartas.add(cartaRelleno);
        }
        cartas.add(cartaEsperada);
        Pilon p = new Columna(new MovimientoLibre(), cartas);

        //Act
        Carta cartaResultado = p.getUltimaCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testObtenerLaPrimeraCartaEsCorrecta() {
        // testeo que la ultima carta del pilon sea la correcta

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        cartas.add(cartaEsperada);
        for (int i = 0; i < 10; i++) {
            cartas.add(cartaRelleno);
        }
        Pilon p = new Columna(new MovimientoLibre(), cartas);

        //Act
        Carta cartaResultado = p.getPrimeraCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testObtenerCartaEnNPosicionEsCorrecta() {
        // testeo que la ultima carta del pilon sea la correcta

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                cartas.add(cartaEsperada);
            }
            cartas.add(cartaRelleno);
        }
        Pilon p = new Columna(new MovimientoLibre(), cartas);

        //Act
        Carta cartaResultado = p.getCarta(5);

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testRecibirCartas() {
        // testeo que se agreguen las cartas recibidas

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        cartas.add(cartaEsperada);
        for (int i = 0; i < 10; i++) {
            cartas.add(cartaRelleno);
        }
        Pilon p = new Columna(new MovimientoLibre());

        //Act
        p.recibirCartas(cartas);
        Carta cartaResultado = p.getPrimeraCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testSacarUnicaCarta() {
        // testeo que se eliminen la carta seleccionada

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON, true);
        cartas.add(cartaEsperada);
        Pilon p = new Columna(new MovimientoLibre(), cartas);
        int tamanoEsperado = 0;

        //Act
        p.sacarPilon(0);
        int tamanoResultado = p.cantidadCartas();

        //Assert
        assertEquals(tamanoEsperado, tamanoResultado);
    }

    public void testSacarUnaCarta() {
        // testeo que se eliminen la carta seleccionada

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON, true);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON,true);
        cartas.add(cartaEsperada);
        cartas.add(cartaRelleno);
        Pilon p = new Columna(new MovimientoLibre(), cartas);

        //Act
        p.sacarPilon(1);
        Carta cartaResultado = p.getUltimaCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testSacarCartas() {
        // testeo que se eliminen las cartas seleccionadas

        //Arrange
        List<Carta> cartas = new ArrayList<>();
        Carta cartaRelleno = new Carta(Numero.K, Palo.CORAZON, true);
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON,true);
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                cartas.add(cartaEsperada);
            }
            cartas.add(cartaRelleno);
        }
        Pilon p = new Columna(new MovimientoLibre(), cartas);

        //Act
        p.sacarPilon(6);
        Carta cartaResultado = p.getUltimaCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testMovimiento() {
        // testeo que el movimiento seteado sea el correcto

        //Arrange
        Movimiento movEsperado = new MovimientoLibre();
        Pilon p = new Columna(new MismoPaloAscendente());

        //Act
        p.setMovimiento(movEsperado);
        Movimiento movResultante = p.getMovimiento();

        //Assert
        assertEquals(movEsperado, movResultante);
    }

}