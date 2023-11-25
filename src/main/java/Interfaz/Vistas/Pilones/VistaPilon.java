package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public abstract class VistaPilon implements Observer {
    Pilon pilon;
    Solitario juego;

    public VistaPilon(Pilon pilon, Solitario juego){
        this.pilon = pilon;
        this.juego = juego;
        pilon.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            //System.out.println("Me llega un update " + this);
            actualizarVista();
        } catch (FileNotFoundException e) {
            System.out.println("Error al hacer el update, " + e.getMessage());
        }
    }
    public abstract void actualizarVista() throws FileNotFoundException;
}
