package Interfaz.Vistas.VistasPrincipales;

import Interfaz.Vistas.Helpers.BibliotecaJuegos;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class VistaBibliotecaJuegos implements VistaPrincipal {

    private final Pane lienzo;

    public VistaBibliotecaJuegos(Pane lienzo) {
        this.lienzo = lienzo;
    }

    @Override
    public void cargar() {
        var bibJuegos = new BibliotecaJuegos(lienzo);
        var botonesJuegos = bibJuegos.getBotonesJuegos();
        VBox buttonBox = new VBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        //buttonBox.setBackground(background);
        //buttonBox.setMaxSize(400, 300);
        buttonBox.getChildren().addAll(botonesJuegos);
        lienzo.getChildren().add(buttonBox);
    }
}
