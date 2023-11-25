package Interfaz.Vistas;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import Interfaz.Vistas.Helpers.ResolvedorVistas;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicioJuego {

    private final StackPane lienzo;

    public VistaInicioJuego(StackPane lienzo) {
        this.lienzo = lienzo;
    }

    public void SetVistaInicial() {

        //Solitario juego = null;

        if (SolitarioPersistidor.getInstance().hayPartidaCargada()) {
            //TODO
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cargar partida guardada?");
            alert.setHeaderText(null);

            ButtonType botonCargar = new ButtonType("Cargar");
            ButtonType botonNueva = new ButtonType("Nueva partida");

            alert.getButtonTypes().setAll(botonCargar, botonNueva);

            // Show the alert and wait for the user's response
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == botonCargar) {
                    setVista(SolitarioPersistidor.getInstance().loadState("asda"));
                    //juego.set(SolitarioPersistidor.getInstance().loadState("asda"));
                } else {
                    setVista(null);
                }
                //stage.close();
            });
        } else {
            // Con este null nos ahorramos crear dos funciones diferentes sólo por la diferencia
            // de haber o no un juego guardado
            setVista(null);
        }


    }


    private void setVista(Solitario juego){
        //StackPane lienzo = new StackPane();
        lienzo.getChildren().clear();
        ResolvedorVistas.SetVista(juego, lienzo).cargar();
    }
}
