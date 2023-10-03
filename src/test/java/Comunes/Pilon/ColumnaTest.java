package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Corazon;
import Movimientos.MovimientoLibre;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ColumnaTest extends TestCase {

    /* public void testObtenerLaUltimaCartaEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(asCorazones);

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getUltimaCarta().equals(asCorazones));
    }

    public void testObtenerLaPrimeraCartaEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.add(asCorazones);
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getPrimeraCarta().equals(asCorazones));
    }

    public void testObtenerCartaEnNPosicionEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(asCorazones);
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));
        cartas.add(mazo.sacarCarta(0));

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getCarta(2).equals(asCorazones));
    }

    public void testIsPilonVacio() {
    }

    public void testCumpleCon() {
    }*/
}