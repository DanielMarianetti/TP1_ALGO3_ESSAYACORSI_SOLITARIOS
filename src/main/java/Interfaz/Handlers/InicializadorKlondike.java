package Interfaz.Handlers;

import Comunes.Juego.Klondike;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Vistas.VistasPrincipales.VistaKlondike;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class InicializadorKlondike extends Button {

    private final Klondike juego;
    private final Pane lienzo;

    public InicializadorKlondike(Pane lienzo){
        this.lienzo = lienzo;

        this.juego = new Klondike();
        juego.iniciarRandom();
        setText("Klondike");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonClick();
            }
        });
    }

    public void handleButtonClick() {

        //var canvas = new Canvas();
        lienzo.getChildren().clear();
        //Klondike juego = new Klondike();
        VistaKlondike vista = new VistaKlondike(juego, lienzo);
        SolitarioPersistidor.getInstance().setJuego(juego);
        vista.cargar();

        /*resizeCanvas(canvas, lienzo.getWidth(), lienzo.getHeight());

        lienzo.widthProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, newVal.doubleValue(), lienzo.getHeight()));

        lienzo.heightProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, lienzo.getWidth(), newVal.doubleValue()));
*/
        //lienzo.getChildren().add(canvas);
        //root.setCenter(canvas);

       // Scene scene = new Scene(root);

       // lienzo.setScene(scene);
    }
}
