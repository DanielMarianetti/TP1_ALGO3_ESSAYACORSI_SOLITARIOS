package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;
import java.util.Observable;

public class VistaPilonTableau extends VistaPilon {

    private final VBox container;
    private int numeroPilon;

    public VistaPilonTableau(Pilon pilon, Solitario solitario, int numeroPilon, Pane container){
        super(pilon, solitario);
        this.numeroPilon = numeroPilon;
        this.container = (VBox) container;
    }

    public void actualizarVista() throws FileNotFoundException {
        //container = (VBox)container; //container.setSpacing()
        int cantidadCartas = pilon.cantidadCartas();
        int MIN_SPACING = -35;
        container.setSpacing(Math.min(-7 * cantidadCartas, MIN_SPACING));
        container.setAlignment(Pos.TOP_RIGHT);
        container.getChildren().clear();
        for(int i = 0; i < cantidadCartas; i++){
            ImageView imagen = ObtensorImagenes.ObtenerImagen(pilon.getCarta(i).obtenerImagenID());
            Pane pane = new Pane(imagen);
            pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            pane.prefHeightProperty().bind(imagen.fitHeightProperty());
            pane.setStyle("-fx-border-color: black; -fx-border-width: 2;");

            container.getChildren().add(pane);
        }
    }
}
