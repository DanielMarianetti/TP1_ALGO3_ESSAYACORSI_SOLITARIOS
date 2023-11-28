package Comunes.Persistencia;

import Comunes.Juego.Solitario;

import java.io.IOException;

public interface Persistidor {

    void setJuego(Solitario juego);
    void saveState();
    Solitario loadState() ;
}
