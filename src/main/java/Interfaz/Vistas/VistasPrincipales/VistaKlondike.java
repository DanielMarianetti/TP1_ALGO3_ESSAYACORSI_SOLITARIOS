package Interfaz.Vistas.VistasPrincipales;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Interfaz.Handlers.SeleccionControlador;
import Interfaz.Vistas.Pilones.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VistaKlondike extends VistaPrincipal {

    private Klondike juego;

    public VistaKlondike(Klondike juego, Pane lienzo) {
        super(lienzo);
        this.juego = juego;
        juego.addObserver(this);
    }

    @Override
    public void cargar() {
        try {
            SeleccionControlador s = new SeleccionControlador(juego,this);

            GridPane tableauDisplay = FXMLLoader.load(getClass().getClassLoader().getResource("templateKlondike.fxml"));
            HBox topDisplay = (HBox) tableauDisplay.lookup("#top");
            HBox mazoYWasteDisplay = (HBox) topDisplay.lookup("#mazoYWaste");
            HBox mazo = (HBox) mazoYWasteDisplay.lookup("#mazo");
            VistaMazo vistaMazo = new VistaMazo(juego.mazo, juego, mazo);
            vistaMazo.actualizarVista();
            HBox waste = (HBox) mazoYWasteDisplay.lookup("#waste");
            VistaWaste vistaWaste = new VistaWaste(juego.waste, juego, waste, s);
            vistaWaste.actualizarVista();
            HBox foundationsDisplay = (HBox) topDisplay.lookup("#foundations");
            foundationsDisplay.setSpacing(10);
            int cantidadFoundations = juego.foundation.size();

            for(int i = 0; i < cantidadFoundations; i++){
                StackPane foundation = new StackPane();

                foundation.setMinWidth(foundationsDisplay.getWidth() / 4);
                foundation.prefWidthProperty().bind(foundationsDisplay.widthProperty().divide(cantidadFoundations));
                foundation.prefHeightProperty().bind(foundationsDisplay.heightProperty());

                VistaFoundation vista = new VistaFoundation(juego.foundation.get(i), juego, i, foundation, s);
                vista.actualizarVista();
                foundationsDisplay.getChildren().add(foundation);

                vistas.add(vista);
            }

            HBox pilonesDisplay = (HBox) tableauDisplay.lookup("#pilones");

            int cantidadPilones = juego.tableau.size();
            for(int i = 0; i < cantidadPilones; i++){
                VBox pilonColumna = new VBox();

                pilonColumna.prefWidthProperty().bind(pilonesDisplay.widthProperty().divide(cantidadPilones));
                pilonColumna.prefHeightProperty().bind(pilonesDisplay.heightProperty());

                VistaPilonTableau vista = new VistaPilonTableau(juego.tableau.get(i), juego, i, pilonColumna, s); //*******************************
                vista.actualizarVista();
                pilonesDisplay.getChildren().add(pilonColumna);

                vistas.add(vista);
            }

            vistas.add(vistaWaste);
            vistas.add(vistaMazo);

            lienzo.getChildren().add(tableauDisplay);

        } catch (IOException e){
            System.out.println("fail al obtener el template");
        }

    }

    public void update() {
        for (VistaPilon v: vistas) {
            try {
                v.actualizarVista();
            } catch (IOException e){
                System.out.println("fail al obtener el template");
            }
        }
    }
}
