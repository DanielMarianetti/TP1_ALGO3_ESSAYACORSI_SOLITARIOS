package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import javafx.scene.layout.Pane;

public class VistaFoundation extends VistaPilon {

    private final Pane container;
    private int numeroFoundation;

    public VistaFoundation(Pilon pilon, Solitario juego, int numeroFoundation, Pane container){
        super(pilon, juego);
        this.numeroFoundation = numeroFoundation;
        this.container = container;
    }

    public void actualizarVista(){

    }
}
