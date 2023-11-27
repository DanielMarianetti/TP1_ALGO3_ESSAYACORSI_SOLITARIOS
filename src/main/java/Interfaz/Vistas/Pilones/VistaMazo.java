package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class VistaMazo extends VistaPilon {

    private final HBox container;

    public VistaMazo(Pilon pilon, Solitario juego, Pane container){
        super(pilon, juego);
        this.container = (HBox) container;
    }

    public void actualizarVista() throws FileNotFoundException {
        container.getChildren().clear();
        if (pilon.cantidadCartas() != 0){
            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta(pilon.getCarta(0).obtenerImagenID());
            Pane pane = new Pane(imagen);
            pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            pane.prefHeightProperty().bind(imagen.fitHeightProperty());

            pane.setOnMouseClicked(event -> juego.moverMazoAWaste());

            container.getChildren().add(pane);
        } else {
            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta("mazoVacio");
            Pane pane = new Pane(imagen);
            pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            pane.prefHeightProperty().bind(imagen.fitHeightProperty());

            pane.setOnMouseClicked(event -> juego.rearmarMazo());
            container.getChildren().add(pane);
        }
    }
}
