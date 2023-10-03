package Comunes.Carta;

import Comunes.Palo.Corazon;
import junit.framework.TestCase;

public class CartaTest extends TestCase {

    public void testCartaEnEstadoInicial() {
        // testeo que una carta se crea con el estado inicial correcto

        //Arrange
        Carta carta = new Carta(Numero.As, new Corazon());
        String estadoEsperado = "Boca Abajo";
        String paloEsperado = "Corazon";
        Numero numeroEsperado = Numero.As;

        //Act

        //Assert
        assertEquals(estadoEsperado, carta.getState());
        assertEquals(paloEsperado, carta.getPalo().getNombre());
        assertEquals (carta.getNumero().ordinal(), (numeroEsperado.ordinal()));
    }

    public void testCambiosDeEstado() {
        // testeo que una carta cambia de estado al recibir ciertos mensajes

        //Arrange
        Carta cartaA = new Carta(Numero.As, new Corazon());
        Carta cartaB = new Carta(Numero.As, new Corazon());
        Carta cartaC = new Carta(Numero.As, new Corazon());
        Carta cartaD = new Carta(Numero.As, new Corazon());
        cartaD.cambiarState(new CartaBocaArribaState(cartaD));
        Carta cartaE = new Carta(Numero.As, new Corazon(), new CartaBocaArribaState(cartaA));
        Carta cartaF = new Carta(Numero.As, new Corazon(), new CartaBocaArribaState(cartaA));
        String estadoEsperadoA = "Boca Abajo";
        String estadoEsperadoB = "Boca Arriba";
        String estadoEsperadoC = "Boca Arriba";
        String estadoEsperadoD = "Boca Abajo";
        String estadoEsperadoE = "Boca Arriba";
        String estadoEsperadoF = "Boca Arriba";

        //Act
        cartaA.traerAlMazo();
        String estadoResultadoA = cartaA.getState();
        cartaB.ultimaPilon();
        String estadoResultadoB = cartaB.getState();
        cartaC.pedirDelMazo();
        String estadoResultadoC = cartaC.getState();
        cartaD.traerAlMazo();
        String estadoResultadoD = cartaD.getState();
        cartaE.ultimaPilon();
        String estadoResultadoE = cartaE.getState();
        cartaF.pedirDelMazo();
        String estadoResultadoF = cartaF.getState();

        //Assert
        assertEquals(estadoEsperadoA, estadoResultadoA);
        assertEquals(estadoEsperadoB, estadoResultadoB);
        assertEquals(estadoEsperadoC, estadoResultadoC);
        assertEquals(estadoEsperadoD, estadoResultadoD);
        assertEquals(estadoEsperadoE, estadoResultadoE);
        assertEquals(estadoEsperadoF, estadoResultadoF);

    }

}


