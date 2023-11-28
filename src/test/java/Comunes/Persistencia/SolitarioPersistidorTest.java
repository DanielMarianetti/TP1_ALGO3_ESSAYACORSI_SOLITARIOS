package Comunes.Persistencia;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SolitarioPersistidorTest extends TestCase {

    private final String pathGuardado = "partidas" + File.separator + "save";
    public void testSaveState() {
        Solitario solitario = new Klondike();
        solitario.iniciarRandom();

        SolitarioPersistidor persistidor = new SolitarioPersistidor();

        persistidor.setJuego(solitario);
        persistidor.saveState();
        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assert fileDeleted;
    }

    public void testLoadState() {
        Solitario solitario = new Klondike();
        solitario.iniciarRandom();

        SolitarioPersistidor persistidor = new SolitarioPersistidor();

        persistidor.setJuego(solitario);
        persistidor.saveState();

        Solitario persistido = persistidor.loadState();
        assertNotNull(persistido);

        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assertTrue(fileDeleted);
    }

    public void testSiNoExisteElDirectorioDeGuardadoIgualSeCrea() {
        SolitarioPersistidor persistidor = new SolitarioPersistidor();
        Klondike solitario = new Klondike();
        File directorio = new File("partidas");
        //Me aseguro que el directorio exista
        if (!directorio.exists()) directorio.mkdir();

        borrarDirectorioRecur(directorio);
        assertFalse(directorio.exists());

        persistidor.setJuego(solitario);
        persistidor.saveState();
        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assert fileDeleted;
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

        persistidor.setJuego(originalSolitario);
        persistidor.saveState();

        Klondike solitarioDeserializado = (Klondike) persistidor.loadState();
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

        File file = new File(pathGuardado);
        boolean fileDeleted = file.delete();
        assertTrue(fileDeleted);
    }
}