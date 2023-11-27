package Interfaz.Vistas.VistasPrincipales;

import Interfaz.Vistas.Helpers.BibliotecaJuegos;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VistaBibliotecaJuegos extends VistaPrincipal {

    public VistaBibliotecaJuegos(Pane lienzo) {
        super(lienzo);
    }

    @Override
    public void cargar() {
        var bibJuegos = new BibliotecaJuegos(lienzo);
        var botonesJuegos = bibJuegos.getBotonesJuegos();
        VBox buttonBox = new VBox(30);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(botonesJuegos);
        lienzo.getChildren().add(buttonBox);
    }

    @Override
    public void update() {
        cargar();
    }
}
