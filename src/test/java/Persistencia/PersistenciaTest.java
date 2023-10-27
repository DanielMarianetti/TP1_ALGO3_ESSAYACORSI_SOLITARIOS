package Persistencia;
import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Movimientos.Movimiento;
import Movimientos.MovimientoLibre;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PersistenciaTest extends TestCase {

    public void testPersistirUnSolitario() {

        Klondike originalSolitario = new Klondike();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            originalSolitario.serializar(outputStream);
            assert true;
        } catch (IOException e){
            e.printStackTrace();
            fail("Excepcion no esperada");
        }
    }

    public void testCargarUnSolitarioDeStream() {

        Klondike originalSolitario = new Klondike();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            originalSolitario.serializar(outputStream);
        } catch (IOException e){
            e.printStackTrace();
            fail("Excepcion no esperada");
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        try {
            Solitario deserializedSolitario = Solitario.deserializar(inputStream);
            assert true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("Excepcion no esperada");
        }
    }

    public void testCargarUnSolitarioDespuesDeGuardarMantieneEstado() {

        Klondike originalSolitario = new Klondike();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            originalSolitario.serializar(outputStream);
        } catch (IOException e){
            e.printStackTrace();
            fail("Excepcion no esperada");
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        try {
            Solitario deserializedSolitario = Solitario.deserializar(inputStream);
            assert true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("Excepcion no esperada");
        }
    }
}
