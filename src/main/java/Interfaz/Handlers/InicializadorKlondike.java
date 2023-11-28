package Interfaz.Handlers;

import Comunes.Juego.Klondike;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Vistas.VistasPrincipales.VistaKlondike;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.Observer;


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

        lienzo.getChildren().clear();

        VistaKlondike vista = new VistaKlondike(juego, lienzo);
        SolitarioPersistidor.getInstance().setJuego(juego);
        vista.cargar();

    }
}
