package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class VistaWaste extends VistaPilon {

    private final HBox container;

    public VistaWaste(Pilon pilon, Solitario juego, Pane container){
        super(pilon, juego);
        this.container = (HBox) container;
    }

    public void actualizarVista() throws FileNotFoundException {
        container.getChildren().clear();
        if (pilon.cantidadCartas() != 0){
            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta(pilon.getUltimaCarta().obtenerImagenID());
            Pane pane = new Pane(imagen);
            pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            pane.prefHeightProperty().bind(imagen.fitHeightProperty());
            pane.setStyle("-fx-border-color: black; -fx-border-width: 2;");

            container.getChildren().add(pane);
        }
    }
}
