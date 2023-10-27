package Comunes.Persistencia;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;

import java.io.*;

public class SolitarioStateHandler {

    public void saveState(Solitario solitario, String filePath) {
        try (FileOutputStream fo = new FileOutputStream(filePath)) {
            solitario.serializar(fo);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Solitario loadState(String filePath) {
        try (FileInputStream fi = new FileInputStream(filePath)) {
            return Solitario.deserializar(fi);
        } catch (IOException  | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return new Klondike();
        }
    }
}
