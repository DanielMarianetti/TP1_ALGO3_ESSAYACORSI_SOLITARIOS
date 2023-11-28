package Interfaz.Vistas.VistasPrincipales;

import Comunes.Juego.Solitario;
import Comunes.Juego.Spider;
import Interfaz.Handlers.SeleccionControlador;
import Interfaz.Vistas.Pilones.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VistaSpider extends VistaPrincipal {

    private Spider juego;

    public VistaSpider(Spider juego, Pane lienzo) {
        super(lienzo);
        this.juego = juego;
        juego.addObserver(this);
    }
    @Override
    public void cargar() {
        try {
            GridPane tableauDisplay = FXMLLoader.load(getClass().getClassLoader().getResource("templateSpider.fxml"));
            HBox topDisplay = (HBox) tableauDisplay.lookup("#top");
            HBox mazoHolder = (HBox) topDisplay.lookup("#mazoHolder");
            HBox mazo = (HBox) mazoHolder.lookup("#mazo");
            VistaMazo vistaMazo = new VistaMazo(juego.mazo, juego, mazo);
            vistaMazo.actualizarVista();
            HBox foundationsDisplay = (HBox) topDisplay.lookup("#foundations");
            int cantidadFoundations = juego.foundation.size();

            SeleccionControlador s = new SeleccionControlador(juego, this);

            for(int i = 0; i < cantidadFoundations; i++){
                StackPane foundation = new StackPane();
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
                VistaPilonTableau vista = new VistaPilonTableau(juego.tableau.get(i), juego, i, pilonColumna, s);
                vista.actualizarVista();
                pilonesDisplay.getChildren().add(pilonColumna);

                vistas.add(vista);
            }

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
