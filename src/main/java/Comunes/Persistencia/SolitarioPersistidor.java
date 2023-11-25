package Comunes.Persistencia;

import Comunes.Juego.Solitario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SolitarioPersistidor implements Persistidor {

    private final String directorioGuardado = "partidas";
    private final String nombreGuardado = "save";
    private static final SolitarioPersistidor INSTANCE = new SolitarioPersistidor();

    private Solitario juego = null;

    public static SolitarioPersistidor getInstance(){
        return INSTANCE;
    }

    public void setJuego(Solitario juego){
        this.juego = juego;
    }

    //TODO cambiar esto porque no usamos los parámetro
    @Override
    public void saveState(Solitario solitario, String path) {
        try {
            if(juego != null) {
                String directoryPath = "partidas";

                File directorioPartidas = new File(directoryPath);

                if (!directorioPartidas.exists()) {
                    boolean directorioCreado = directorioPartidas.mkdir();
                    if (!directorioCreado) {
                        throw new IOException("Error al querer crear el directorio de partidas.");
                    }
                }

                String fullPath = directoryPath + File.separator + nombreGuardado;

                FileOutputStream fo = new FileOutputStream(fullPath);
                juego.serializar(fo);
                fo.close();
                this.setJuego(null);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Error al intentar guardar la partida, se perderá el progreso");
        }

    }

    //TODO sacar parametro
    @Override
    public Solitario loadState(String path) {
        String fullPath = "partidas" + File.separator + nombreGuardado;
        try (FileInputStream fi = new FileInputStream(fullPath)) {
            return Solitario.deserializar(fi);
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean hayPartidaCargada(){
        Path path = Paths.get(directorioGuardado, nombreGuardado);

        return Files.exists(path);
    }
    public boolean hayJuego() {
        return juego != null;
    }

    public void eliminarGuardado() {
        Path path = Paths.get(directorioGuardado, nombreGuardado);

        try {
            Files.delete(path);
            System.out.println("Progreso de partida eliminado");
        } catch (IOException e) {
            System.out.println("Error borrando el archivo de guardado: " + e.getMessage());
        }
    }
}
