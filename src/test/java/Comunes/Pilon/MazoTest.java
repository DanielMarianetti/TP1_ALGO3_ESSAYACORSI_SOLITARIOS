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

public class MazoTest extends TestCase {

    private final int CARTAS_TOTALES_MAZO = 52;

    public void testCrearMazoVacio(){
        // testeo que el mazo se cree de forma correcta

        //Arrange
        Pilon mazo = new Mazo(new MovimientoLibre());

        //Act

        //Assert
        assertTrue(mazo.isPilonVacio());
    }

    public void testCrearMazoConCartas(){
        // testeo que el mazo se cree de forma correcta

        //Arrange
        Pilon mazo = new Mazo(new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.K, Palo.TREBOL);
        List<Carta> cartas = new ArrayList<>();
        cartas.add(cartaEsperada);

        //Act
        mazo.setCartas(cartas);
        Carta cartaResultado = mazo.getUltimaCarta();

        //Assert
        assertFalse(mazo.isPilonVacio());
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testCrearMazoTieneTodasLasCartas(){
        // testeo que el mazo se cree de forma correcta

        //Arrange
        Pilon mazo = new Mazo(true, new MovimientoLibre());

        //Act

        //Assert
        assertEquals(mazo.cantidadCartas(), 52);
    }

    public void testCrearMazoOrdenado(){
        // testeo que el mazo este ordenado

        //Arrange
        Pilon mazo = new Mazo(true, new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.K, Palo.TREBOL);

        //Act
        Carta cartaResultado = mazo.getUltimaCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testObtenerLaUltimaCartaEsCorrecta() {
        // testeo que la ultima carta del mazo sea la correcta

        //Arrange
        Pilon mazo = new Mazo(true, new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.K, Palo.TREBOL);

        //Act
        Carta cartaResultado = mazo.getUltimaCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testObtenerLaPrimeraCartaEsCorrecta() {
        // testeo que la ultima carta del mazo sea la correcta

        //Arrange
        Pilon mazo = new Mazo(true, new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.AS, Palo.CORAZON);

        //Act
        Carta cartaResultado = mazo.getPrimeraCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testObtenerCartaEnNPosicionEsCorrecta() {
        // testeo que la carta seleccionada del mazo sea la correcta

        //Arrange
        Pilon mazo = new Mazo(true, new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.TRES, Palo.CORAZON);

        //Act
        Carta cartaResultado = mazo.getCarta(2);

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
    }

    public void testCrearMazoDesordenadoTieneTodasLasCartasDesordenadas(){
        //Arrange
        Pilon mazoOrdenado = new Mazo(true, new MovimientoLibre());
        Pilon desOrdenado = new Mazo(false, new MovimientoLibre());

        Carta primeraCartaOrdenado = mazoOrdenado.getUltimaCarta();
        Carta primeraCartaDesordenado = desOrdenado.getUltimaCarta();
        Carta segundaCartaOrdenado = mazoOrdenado.getUltimaCarta();
        Carta segundaCartaDesordenado = desOrdenado.getUltimaCarta();

        //Act

        //Assert
        assertEquals(desOrdenado.cantidadCartas(), CARTAS_TOTALES_MAZO);
        assertFalse(primeraCartaOrdenado.equals(primeraCartaDesordenado) && segundaCartaOrdenado.equals(segundaCartaDesordenado));
    }

    public void testTomarTodasLasCartasHaceQueElMasoQuedeVacio() {
        //Arrange
        Pilon mazoOrdenado = new Mazo(true, new MovimientoLibre());

        //Act
        for(int i = 0; i < CARTAS_TOTALES_MAZO; i++){
            mazoOrdenado.sacarPilon(0);
        }

        //Assert
        assert mazoOrdenado.isPilonVacio();
    }

    public void testTomarAlgunasCartasHaceQueElMasoPierdaCartas() {
        //Arrange
        Pilon mazoOrdenado = new Mazo(true, new MovimientoLibre());
        int cartasTomadas = 4;

        //Act
        for(int i = 0; i < cartasTomadas; i++){
            mazoOrdenado.sacarPilon(0);
        }

        //Assert
        assertFalse(mazoOrdenado.isPilonVacio());
        assertEquals(mazoOrdenado.cantidadCartas(), (CARTAS_TOTALES_MAZO - cartasTomadas));
    }

    public void testSacarUnicaCarta() {
        // testeo que se eliminen la carta seleccionada

        //Arrange
        Pilon mazo = new Mazo(new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        int tamanoEsperado = 0;
        List<Carta> cartas = new ArrayList<>();
        cartas.add(cartaEsperada);
        mazo.recibirCartas(cartas);

        //Act
        mazo.sacarPilon(0);
        int tamanoResultado = mazo.cantidadCartas();

        //Assert
        assertEquals(tamanoEsperado, tamanoResultado);
    }

    public void testRecibirCartas() {
        // testeo que se agreguen las cartas recibidas

        //Arrange
        Pilon mazo = new Mazo(new MovimientoLibre());
        Carta cartaEsperada = new Carta(Numero.Q, Palo.CORAZON);
        int tamanoEsperado = 1;
        List<Carta> cartas = new ArrayList<>();
        cartas.add(cartaEsperada);

        //Act
        mazo.recibirCartas(cartas);
        int tamanoResultado = mazo.cantidadCartas();
        Carta cartaResultado = mazo.getPrimeraCarta();

        //Assert
        assertTrue(cartaEsperada.equals(cartaResultado));
        assertEquals(tamanoEsperado, tamanoResultado);
    }

    public void testMovimiento() {
        // testeo que el movimiento seteado sea el correcto

        //Arrange
        Movimiento movEsperado = new MovimientoLibre();
        Pilon mazo = new Mazo(new MismoPaloAscendente());

        //Act
        mazo.setMovimiento(movEsperado);
        Movimiento movResultante = mazo.getMovimiento();

        //Assert
        assertEquals(movEsperado, movResultante);
    }

}