package Comunes.Persistencia;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SolitarioPersistidorTest extends TestCase {

    public void testSaveState() {
        Solitario solitario = new Klondike();
        solitario.iniciarRandom();

        SolitarioPersistidor persistidor = new SolitarioPersistidor();

        String fileName = "fileNameGuardado";
        try {
            persistidor.saveState(solitario, fileName);
            File file = new File("partidas" + File.separator + fileName);
            boolean fileDeleted = file.delete();
            assert fileDeleted;
        } catch (IOException e){
            fail("Excepcion no esperada");
        }
    }

    public void testLoadState() {
        Solitario solitario = new Klondike();
        solitario.iniciarRandom();

        SolitarioPersistidor persistidor = new SolitarioPersistidor();

        String fileName = "fileNameGuardado";
        String pathGuardado = "partidas" + File.separator + fileName;

        try {
            persistidor.saveState(solitario, fileName);
        } catch (IOException e){
            fail("Excepcion no esperada");
        }

        try {
            Solitario persistido = persistidor.loadState(fileName);
            assertNotNull(persistido);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Excepcion no esperada");
        }

        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assertTrue(fileDeleted);
    }

    public void testAbrirArchivoQueNoExisteArrojaExcepcion() {
        SolitarioPersistidor persistidor = new SolitarioPersistidor();

        try {
            persistidor.loadState("cualquiera");
            fail("No debe abrir un archivo que no existe");
        } catch (IOException e) {
            assert true;
        }
    }
    public void testSiNoExisteElDirectorioDeGuardadoIgualSeCrea() {
        SolitarioPersistidor persistidor = new SolitarioPersistidor();
        Klondike solitario = new Klondike();
        File directorio = new File("partidas");
        //Me aseguro que el directorio exista
        if (!directorio.exists()) directorio.mkdir();

        borrarDirectorioRecur(directorio);
        assertFalse(directorio.exists());

        String fileName = "fileNameGuardado";
        try {
            persistidor.saveState(solitario, fileName);
            File file = new File("partidas" + File.separator + fileName);
            boolean fileDeleted = file.delete();
            assert fileDeleted;
        } catch (IOException e){
            fail("Excepcion no esperada");
        }
    }

    ///Función auxiliar para borrar el directorio con todos sus contenidos
    private void borrarDirectorioRecur(File directorio) {
        if (directorio.exists()) {
            File[] files = directorio.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        borrarDirectorioRecur(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directorio.delete();
        }
    }


    public void testCargarUnSolitarioDespuesDeGuardarMantieneEstado() {

        Klondike originalSolitario = new Klondike();
        originalSolitario.iniciarRandom();

        Persistidor persistidor = new SolitarioPersistidor();
        String pathGuardado = "partidas" + File.separator + "test";


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

        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assertTrue(fileDeleted);
    }
}