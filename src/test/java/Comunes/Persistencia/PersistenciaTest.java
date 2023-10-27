package Comunes.Persistencia;
import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

public class PersistenciaTest extends TestCase {

    // Con estos tests buscamos probar que la funcion de serializar funciona correctamente, ya que podemos
    // estar seguros que el crear un buffer de bytes no generará problemas al usar el mock.
    // Luego probaremos el persistidor usado en particular
    public void testPersistirUnSolitario() {

        Klondike originalSolitario = new Klondike();

        //Usaremos esta clase de Mock que guarda la info en un byteStream para test
        Persistidor persistidor = new MockPersistidor();

        try {
            persistidor.saveState(originalSolitario, "test");
            assert true;
        } catch (IOException e){
            fail("Excepcion no esperada");
        }
    }

    public void testCargarUnSolitarioDeStream() {

        Klondike originalSolitario = new Klondike();

        Persistidor persistidor = new MockPersistidor();

        try {
            persistidor.saveState(originalSolitario, "test");
        } catch (IOException e){
            e.printStackTrace();
            fail("Excepcion no esperada");
        }

        try {
            Solitario solitario = persistidor.loadState("test");
            assert solitario != null;
        } catch (IOException e) {
            e.printStackTrace();
            fail("Excepcion no esperada");
        }
    }

    public void testCargarUnSolitarioDespuesDeGuardarMantieneEstado() {

        Klondike originalSolitario = new Klondike();
        originalSolitario.iniciarRandom();

        Persistidor persistidor = new MockPersistidor();

        try {
            persistidor.saveState(originalSolitario, "test");
        } catch (IOException e){
            e.printStackTrace();
            fail("Excepcion no esperada");
        }

        try {
            Klondike solitarioDeserializado = (Klondike) persistidor.loadState("test");
            List<Pilon> tableauOriginal = originalSolitario.tableau;
            List<Pilon> tableauDeserializado = solitarioDeserializado.tableau;

            for(int i = 0; i < 7; i++){
                Pilon pilonOriginal = tableauOriginal.get(i);
                Pilon pilonDeserializado = tableauDeserializado.get(i);

                assertEquals(pilonOriginal.cantidadCartas(), pilonDeserializado.cantidadCartas());
                for(int j = 0; j < pilonOriginal.cantidadCartas(); j++){
                    assertTrue(pilonOriginal.getCarta(j).equals(pilonDeserializado.getCarta(j)));
                }
            }

            Pilon mazoOriginal = originalSolitario.mazo;
            Pilon mazoDeserializado = solitarioDeserializado.mazo;

            assertEquals(mazoOriginal.cantidadCartas(), mazoDeserializado.cantidadCartas());

            for(int j = 0; j < mazoOriginal.cantidadCartas(); j++){
                assertTrue(mazoOriginal.getCarta(j).equals(mazoDeserializado.getCarta(j)));
            }

        } catch (IOException e) {
            e.printStackTrace();
            fail("Excepcion no esperada");
        }
    }
}
