package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Handlers.SeleccionControlador;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class VistaPilonTableau extends VistaPilon {

    private final VBox container;
    private int numeroPilon;
    private SeleccionControlador s;

    public VistaPilonTableau(Pilon pilon, Solitario solitario, int numeroPilon, Pane container, SeleccionControlador s){
        super(pilon, solitario);
        this.numeroPilon = numeroPilon;
        this.container = (VBox) container;
        this.container.setAlignment(Pos.TOP_RIGHT);
        this.s = s;
    }

    public void actualizarVista() throws FileNotFoundException {

        int cantidadCartas = pilon.cantidadCartas();

        container.getChildren().clear();

        if(cantidadCartas == 0) {
            Pane pane = new Pane();
            pane.setPrefSize(73, 90);

            // Set white borders using CSS
            pane.setStyle(
                    "-fx-border-color: white white white white;" +
                    "-fx-border-width: 1 1 1 1;" +
                    "-fx-border-style: solid;"
            );

            pane.setOnMouseClicked(event -> s.handleClickPilon(numeroPilon, 0));

            container.getChildren().add(pane);
        }

        for(int i = 0; i < cantidadCartas; i++){

            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta(pilon.getCarta(i).obtenerImagenID());
            Pane pane = new Pane(imagen);
            pane.prefWidthProperty().bind(imagen.fitWidthProperty());
            pane.prefHeightProperty().bind(imagen.fitHeightProperty());

            final int alt = i;
            pane.setOnMouseClicked(event -> s.handleClickPilon(numeroPilon, alt));

            container.getChildren().add(pane);
        }

        int MIN_SPACING = -70;
        double defaultSpacing = container.getSpacing();
        container.setSpacing(Math.min(defaultSpacing, MIN_SPACING));
    }

}
