package Comunes.Carta;

import junit.framework.TestCase;

public class CartaTest extends TestCase {

    public void testCartaEnEstadoInicial() {
        // testeo que una carta se crea con el estado inicial correcto

        //Arrange
        Carta carta = new Carta(Numero.AS, Palo.CORAZON, true);
        boolean estadoEsperado = true;
        Numero numeroEsperado = Numero.AS;
        Palo paloEsperado = Palo.CORAZON;

        //Act

        //Assert
        assertEquals(estadoEsperado, carta.isBocaArriba());
        assertEquals(paloEsperado, carta.getPalo());
        assertEquals(numeroEsperado, carta.getNumero());
    }

    public void testSetEstado() {
        // testeo que una carta cambia de estado al recibir el mensaje

        //Arrange
        Carta cartaA = new Carta(Numero.AS, Palo.CORAZON, true);
        Carta cartaB = new Carta(Numero.AS, Palo.CORAZON, false);
        boolean estadoEsperadoA = false;
        boolean estadoEsperadoB = true;

        //Act
        cartaA.setBocaArriba(false);
        boolean estadoResultadoA = cartaA.isBocaArriba();
        cartaB.setBocaArriba(true);
        boolean estadoResultadoB = cartaB.isBocaArriba();

        //Assert
        assertEquals(estadoEsperadoA, estadoResultadoA);
        assertEquals(estadoEsperadoB, estadoResultadoB);
    }

    public void testCartaIguales() {
        // testeo que una carta cambia de estado al recibir el mensaje

        //Arrange
        Carta cartaA = new Carta(Numero.AS, Palo.CORAZON);
        Carta cartaB = new Carta(Numero.AS, Palo.CORAZON);
        Carta cartaC = new Carta(Numero.AS, Palo.DIAMANTE);
        boolean estadoEsperado = true;

        //Act

        //Assert
        assertTrue("", cartaA.equals(cartaB));
        assertFalse("", cartaA.equals(cartaC));
    }
}


