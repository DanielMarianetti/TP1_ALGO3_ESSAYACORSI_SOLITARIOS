package Interfaz.Vistas.Pilones;

import Comunes.Juego.Solitario;
import Comunes.Pilon.Pilon;
import Interfaz.Handlers.SeleccionControlador;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;

public class VistaFoundation extends VistaPilon {

    private final StackPane container;
    private int numeroFoundation;

    private SeleccionControlador s;

    public VistaFoundation(Pilon pilon, Solitario juego, int numeroFoundation, Pane container, SeleccionControlador s){
        super(pilon, juego);
        this.numeroFoundation = numeroFoundation;
        this.container = (StackPane) container;

        this.s = s;
        container.setStyle("-fx-border-color: black; -fx-border-width: 2;");
    }

    public void actualizarVista() throws FileNotFoundException {
        int cantidadCartas = pilon.cantidadCartas();

        for(int i = 0; i < cantidadCartas; i++){
            ImageView imagen = ObtensorImagenes.ObtenerImagenCarta(pilon.getUltimaCarta().obtenerImagenID());

            container.getChildren().add(imagen);
        }

        StackPane pane = new StackPane();
        pane.setOnMouseClicked(mouseEvent -> s.handleClickFoundation(numeroFoundation, 0, pane));
        container.getChildren().add(pane);

    }
}