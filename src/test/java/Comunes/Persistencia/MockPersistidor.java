package Comunes.Persistencia;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Persistencia.Persistidor;

import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class MockPersistidor implements Persistidor {

    private Dictionary<String, ByteArrayOutputStream>  streamsDic;

    public MockPersistidor(){
        streamsDic = new Hashtable<>();
    }
    @Override
    public void saveState(Solitario solitario, String filePath) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        solitario.serializar(outputStream);
        streamsDic.put(filePath, outputStream);
    }

    private Solitario errorApertura(String mensaje) throws IOException{
        System.out.println(mensaje);
        throw new IOException();
    }

    @Override
    public Solitario loadState(String filePath) throws IOException {
        ByteArrayOutputStream out = streamsDic.get(filePath);
        if(out == null){
            return errorApertura("No se encontró un stream con ese nombre");
        }
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(out.toByteArray())) {
            return Solitario.deserializar(inputStream);
        } catch ( ClassNotFoundException e){
            return errorApertura(e.getMessage());
        }
    }
}
