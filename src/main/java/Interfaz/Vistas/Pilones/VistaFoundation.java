package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;

public class VistaFoundation extends VistaPilon {

    private final StackPane container;
    private int numeroFoundation;

    public VistaFoundation(Pilon pilon, Solitario juego, int numeroFoundation, Pane container){
        super(pilon, juego);
        this.numeroFoundation = numeroFoundation;
        this.container = (StackPane) container;
        container.setStyle("-fx-border-color: black; -fx-border-width: 2;");
    }

    public void actualizarVista() throws FileNotFoundException {
        int cantidadCartas = pilon.cantidadCartas();
        //int MIN_SPACING = -35;
        //container.setSpacing(Math.min(-7 * cantidadCartas, MIN_SPACING));
        //container.setAlignment(Pos.TOP_RIGHT);
        //container.getChildren().clear();
        for(int i = 0; i < cantidadCartas; i++){
            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta(pilon.getUltimaCarta().obtenerImagenID());
            //Pane pane = new Pane(imagen);
            //pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            //pane.prefHeightProperty().bind(imagen.fitHeightProperty());
           // pane.setStyle("-fx-border-color: black; -fx-border-width: 2;");

            container.getChildren().add(imagen);
        }
        //int MIN_SPACING = -35;
        //double defaultSpacing = container.getSpacing();
        //container.setSpacing(Math.min(defaultSpacing, MIN_SPACING));
    }
}
