package Objetivos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Pilon.Columna;
import Comunes.Pilon.Pilon;
import Movimientos.MismoPaloAscendente;
import Movimientos.MismoPaloDescendente;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class PilonSecuenciaCompletaTest extends TestCase {

    public void testPilonCompleto() {

        Objetivo obj = new PilonSecuenciaCompleta();
        List<Pilon> columnas = new ArrayList<>();
        Pilon p = new Columna(new MismoPaloDescendente());
        List<Carta> cartas = new ArrayList<>();

        Carta carta = new Carta(Numero.K, Palo.TREBOL,true);
        cartas.add(carta);
        carta = new Carta(Numero.Q, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.J, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.DIEZ, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.NUEVE, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.OCHO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.SIETE, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.SEIS, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.CINCO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.CUATRO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.TRES, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.DOS, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.AS, Palo.TREBOL);
        cartas.add(carta);

        p.setCartas(cartas);
        columnas.add(p);

        assert (obj.cumplido(columnas));

    }

    public void testPilonIncompleto() {
        Objetivo obj = new PilonSecuenciaCompleta();
        List<Pilon> columnas = new ArrayList<>();
        Pilon p = new Columna(new MismoPaloDescendente());
        List<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta(Numero.K, Palo.TREBOL,true);
        cartas.add(carta);
        carta = new Carta(Numero.J, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.DIEZ, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.NUEVE, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.OCHO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.SIETE, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.SEIS, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.CINCO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.CUATRO, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.TRES, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.DOS, Palo.TREBOL);
        cartas.add(carta);
        carta = new Carta(Numero.AS, Palo.TREBOL);
        cartas.add(carta);

        p.setCartas(cartas);
        columnas.add(p);

        assertFalse(obj.cumplido(columnas));
    }

}