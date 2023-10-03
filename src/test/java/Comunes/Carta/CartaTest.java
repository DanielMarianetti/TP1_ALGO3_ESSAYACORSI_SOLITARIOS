package Comunes.Carta;

import Comunes.Palo.Corazon;
import Comunes.Palo.Palo;
import junit.framework.TestCase;

public class CartaTest extends TestCase {

    public void testCartaEnEstadoInicial() {
        // testeo que una carta se crea con el estado inicial correcto

        //Arrange
        Carta carta = new Carta(Numero.As, new Corazon());
        CartaBocaAbajoState estadoEsperado = new CartaBocaAbajoState(carta);
        Palo paloEsperado = new Corazon();
        Numero numeroEsperado = Numero.As;

        //Act

        //Assert
        assertEquals (carta.getState().tomar(),estadoEsperado.tomar());
        // chequear palo
        assertEquals (carta.getNumero().ordinal(), (numeroEsperado.ordinal()));
    }

}


