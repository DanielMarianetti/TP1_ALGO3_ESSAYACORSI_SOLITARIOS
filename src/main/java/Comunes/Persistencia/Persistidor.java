package Comunes.Persistencia;

import Comunes.Juego.Solitario;

import java.io.IOException;

public interface Persistidor {

    void saveState(Solitario solitario, String filePath) throws IOException;
    Solitario loadState(String filePath) throws IOException;
}
