package Interfaz.Vistas.VistasPrincipales;

import Comunes.Juego.Klondike;
import Comunes.Juego.Spider;
import Interfaz.Vistas.Pilones.VistaFoundation;
import Interfaz.Vistas.Pilones.VistaMazo;
import Interfaz.Vistas.Pilones.VistaPilonTableau;
import Interfaz.Vistas.Pilones.VistaWaste;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;

public class VistaSpider implements VistaPrincipal {

    private Spider juego;
    private Pane lienzo;

    public VistaSpider(Spider juego, Pane lienzo) {
        this.juego = juego;
        this.lienzo = lienzo;
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
            for(int i = 0; i < cantidadFoundations; i++){
                StackPane foundation = new StackPane();
                foundation.prefWidthProperty().bind(foundationsDisplay.widthProperty().divide(cantidadFoundations));
                foundation.prefHeightProperty().bind(foundationsDisplay.heightProperty());
                VistaFoundation vista = new VistaFoundation(juego.foundation.get(i), juego, i, foundation);
                vista.actualizarVista();
                foundationsDisplay.getChildren().add(foundation);
            }
            HBox pilonesDisplay = (HBox) tableauDisplay.lookup("#pilones");
            int cantidadPilones = juego.tableau.size();
            for(int i = 0; i < cantidadPilones; i++){
                VBox pilonColumna = new VBox();
                pilonColumna.prefWidthProperty().bind(pilonesDisplay.widthProperty().divide(cantidadPilones));
                pilonColumna.prefHeightProperty().bind(pilonesDisplay.heightProperty());
                VistaPilonTableau vista = new VistaPilonTableau(juego.tableau.get(i), juego, i, pilonColumna);
                vista.actualizarVista();
                pilonesDisplay.getChildren().add(pilonColumna);
            }

            lienzo.getChildren().add(tableauDisplay);
        } catch (IOException e){
            System.out.println("fail al obtener el template");
        }
    }
}
