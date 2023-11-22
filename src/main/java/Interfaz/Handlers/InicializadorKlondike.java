package Interfaz.Handlers;

import Comunes.Juego.Klondike;
import Interfaz.Vistas.VistaInicial;
import Interfaz.Vistas.VistaKlondike;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class InicializadorKlondike extends Button {

    private Pane lienzo;
    private VistaInicial observer;

    public InicializadorKlondike(Pane lienzo, VistaInicial observer){
        this.lienzo = lienzo;
        this.observer = observer;
        setText("Klondike");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonClick();
            }
        });
    }

    public void handleButtonClick() {

        var canvas = new Canvas();

        Klondike juego = new Klondike();
        VistaKlondike vista = new VistaKlondike(juego, lienzo, observer);
        vista.Cargar();

        /*resizeCanvas(canvas, lienzo.getWidth(), lienzo.getHeight());

        lienzo.widthProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, newVal.doubleValue(), lienzo.getHeight()));

        lienzo.heightProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, lienzo.getWidth(), newVal.doubleValue()));
*/
        lienzo.getChildren().add(canvas);
        //root.setCenter(canvas);

       // Scene scene = new Scene(root);

       // lienzo.setScene(scene);
    }
}
