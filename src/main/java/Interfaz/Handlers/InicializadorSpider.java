package Interfaz.Handlers;

import Comunes.Juego.Spider;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Vistas.VistasPrincipales.VistaSpider;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class InicializadorSpider extends Button {

    private final Spider juego;
    private final Pane lienzo;
    public InicializadorSpider(Pane lienzo){
        this.lienzo = lienzo;
        this.juego = new Spider();
        juego.iniciarRandom();
        setText("Spider");

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonClick();
            }
        });
    }

    public void handleButtonClick() {
        //BorderPane root = new BorderPane();
        lienzo.getChildren().clear();
        //Spider juego = new Spider();
        //Llamado a la vista
        VistaSpider vista = new VistaSpider(juego, lienzo);
        SolitarioPersistidor.getInstance().setJuego(juego);
        vista.cargar();
    }
}
