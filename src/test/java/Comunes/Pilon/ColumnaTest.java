package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Corazon;
import Comunes.Palo.Diamante;
import Comunes.Palo.Pica;
import Comunes.Palo.Trebol;
import Movimientos.ColorIntercaladoDescendente;
import Movimientos.MismoPaloAscendente;
import Movimientos.MovimientoLibre;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ColumnaTest extends TestCase {

    public void testObtenerLaUltimaCartaEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.add(asCorazones);

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getUltimaCarta().equals(asCorazones));
    }

    public void testObtenerLaPrimeraCartaEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.add(asCorazones);
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getPrimeraCarta().equals(asCorazones));
    }

    public void testObtenerCartaEnNPosicionEsCorrecta() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Mazo mazo = new Mazo(false, new MovimientoLibre());
        Carta asCorazones = new Carta(Numero.As, new Corazon());

        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.add(asCorazones);
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));
        cartas.addAll(mazo.sacarPilon(0));

        Columna columna = new Columna(new MovimientoLibre(), cartas);

        assert (columna.getCarta(2).equals(asCorazones));
    }

    public void testSacarLaCartaBaseDeUnaColumnaQueNoSigueElMovimientoDeterminadoNoSacaCartas() {
        ArrayList<Carta> cartas = new ArrayList<>();
        Columna columna = new Columna(new MismoPaloAscendente());

        Carta carta = new Carta(Numero.Q, new Corazon());
        cartas.add(carta);
        carta = new Carta(Numero.J, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Diez, new Diamante());
        cartas.add(carta);
        carta = new Carta(Numero.Nueve, new Trebol());
        cartas.add(carta);

        columna.setCartas(cartas);

        int cantidadAnterior = columna.cantidadCartas();

        columna.sacarPilon(0);

        assertEquals(cantidadAnterior, columna.cantidadCartas());
    }

    public void testSacarLaCartaBaseDeUnaColumnaQueSigueElMovimientoDeterminadoDejaElPilonVacio() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Columna columna = new Columna(new ColorIntercaladoDescendente());

        Carta carta = new Carta(Numero.Q, new Corazon());
        cartas.add(carta);
        carta = new Carta(Numero.J, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Diez, new Diamante());
        cartas.add(carta);
        carta = new Carta(Numero.Nueve, new Trebol());
        cartas.add(carta);

        columna.setCartas(cartas);
        columna.sacarPilon(0);

        assert (columna.isPilonVacio());
    }

    public void testSacarUnaCartaDeUnaColumnaQueSigueElMovimientoDeterminadoDejaElPilonConLasCartasAnterioresSolamente() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Columna columna = new Columna(new ColorIntercaladoDescendente());

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Q, new Corazon());
        cartas.add(carta);
        carta = new Carta(Numero.J, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Diez, new Diamante());
        cartas.add(carta);
        carta = new Carta(Numero.Nueve, new Trebol());
        cartas.add(carta);

        columna.setCartas(cartas);

        columna.sacarPilon(2);

        assertEquals(columna.cantidadCartas(), 2);
    }

    public void testSacarUnPilonDeUnaColumnaQueSigueElMovimientoDeterminadoExceptoLaUltimaNoSacaCartas() {

        ArrayList<Carta> cartas = new ArrayList<>();
        Columna columna = new Columna(new ColorIntercaladoDescendente());

        Carta carta = new Carta(Numero.Dos, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Seis, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Q, new Corazon());
        cartas.add(carta);
        carta = new Carta(Numero.J, new Pica());
        cartas.add(carta);
        carta = new Carta(Numero.Diez, new Diamante());
        cartas.add(carta);
        carta = new Carta(Numero.Nueve, new Trebol());
        cartas.add(carta);
        carta = new Carta(Numero.Tres, new Pica());
        cartas.add(carta);

        columna.setCartas(cartas);
        int cantidadAnterior = columna.cantidadCartas();

        columna.sacarPilon(2);

        assertEquals(columna.cantidadCartas(), cantidadAnterior);
    }
}