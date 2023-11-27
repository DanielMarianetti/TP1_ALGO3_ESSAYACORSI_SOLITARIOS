package Interfaz.Handlers;

import Interfaz.Vistas.VistaInicioJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import java.util.Observer;

public class InicioJuego implements EventHandler<ActionEvent> {

    private final StackPane lienzo;


    public InicioJuego(StackPane lienzo) {this.lienzo = lienzo; }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaInicioJuego vistaInicioJuego = new VistaInicioJuego(lienzo);
        vistaInicioJuego.SetVistaInicial();
    }
}
