package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.MovimientoLibre;
import junit.framework.TestCase;

public class MazoTest extends TestCase {
    /*
    private final int CARTAS_TOTALES_MAZO = 52;
    public void testCrearMasoTieneTodasLasCartas(){
        Mazo mazo = new Mazo(true, new MovimientoLibre());

        assertEquals(mazo.cantidadCartas(), 52);
    }

    public void testCrearMasoDesordenadoTieneTodasLasCartasDesordenadas(){
        Mazo mazoOrdenado = new Mazo(true, new MovimientoLibre());
        Mazo desOrdenado = new Mazo(false, new MovimientoLibre());

        Carta primeraCartaOrdenado = mazoOrdenado.getUltimaCarta();
        Carta primeraCartaDesordenado = desOrdenado.getUltimaCarta();
        Carta segundaCartaOrdenado = mazoOrdenado.getUltimaCarta();
        Carta segundaCartaDesordenado = desOrdenado.getUltimaCarta();

        assertEquals(desOrdenado.cantidadCartas(), CARTAS_TOTALES_MAZO);
        assertFalse(primeraCartaOrdenado.equals(primeraCartaDesordenado) && segundaCartaOrdenado.equals(segundaCartaDesordenado));
    }
    public void testTomarTodasLasCartasHaceQueElMasoQuedeVacio() {
        Mazo mazoOrdenado = new Mazo(true, new MovimientoLibre());

        for(int i = 0; i < CARTAS_TOTALES_MAZO; i++){
            mazoOrdenado.sacarPilon(0);
        }

        assert mazoOrdenado.isPilonVacio();
    }

    public void testTomarAlgunasCartasHaceQueElMasoPierdaCartas() {
        Mazo mazoOrdenado = new Mazo(true, new MovimientoLibre());

        int cartasTomadas = 4;

        for(int i = 0; i < cartasTomadas; i++){
            mazoOrdenado.sacarPilon(0);
        }

        assertFalse(mazoOrdenado.isPilonVacio());

        assertEquals(mazoOrdenado.cantidadCartas(), (CARTAS_TOTALES_MAZO - cartasTomadas));
    }*/
}