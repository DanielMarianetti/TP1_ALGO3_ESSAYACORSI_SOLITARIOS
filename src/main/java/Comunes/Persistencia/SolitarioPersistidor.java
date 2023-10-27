package Comunes.Persistencia;

import Comunes.Juego.Solitario;

import java.io.*;

public class SolitarioPersistidor implements Persistidor {

    @Override
    public void saveState(Solitario solitario, String filePath) throws IOException {
        String directoryPath = "partidas";

        File directorioPartidas = new File(directoryPath);

        if (!directorioPartidas.exists()) {
            boolean directorioCreado = directorioPartidas.mkdir();
            if (!directorioCreado) {
                throw new IOException("Error al querer crear el directorio de partidas.");
            }
        }

        String fullPath = directoryPath + File.separator + filePath;

        FileOutputStream fo = new FileOutputStream(fullPath);
        solitario.serializar(fo);
        fo.close();
    }

    @Override
    public Solitario loadState(String filePath) throws IOException {
        String fullPath = "partidas" + File.separator + filePath;
        try (FileInputStream fi = new FileInputStream(fullPath)) {
            return Solitario.deserializar(fi);
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
