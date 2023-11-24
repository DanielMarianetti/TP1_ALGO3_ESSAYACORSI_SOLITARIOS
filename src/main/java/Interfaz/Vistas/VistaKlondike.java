package Interfaz.Vistas;

import Comunes.Juego.Klondike;
import Interfaz.Vistas.Pilones.VistaFoundation;
import Interfaz.Vistas.Pilones.VistaMazo;
import Interfaz.Vistas.Pilones.VistaPilonTableau;
import Interfaz.Vistas.Pilones.VistaWaste;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Objects;

public class VistaKlondike {

    private Klondike juego;
    private Pane lienzo;

    public VistaKlondike(Klondike juego, Pane lienzo) {
        this.juego = juego;
        this.lienzo = lienzo;
    }

    public void Cargar() {
        try {
            juego.iniciarRandom();
            GridPane tableauDisplay = FXMLLoader.load(getClass().getClassLoader().getResource("templateKlondike.fxml"));
            HBox topDisplay = (HBox) tableauDisplay.lookup("#top");
            //topDisplay.setSpacing(10);
            HBox mazoYWasteDisplay = (HBox) topDisplay.lookup("#mazoYWaste");
            //mazoYWasteDisplay.setSpacing(20);
            HBox mazo = (HBox) mazoYWasteDisplay.lookup("#mazo");
            mazo.setBackground(new Background(new BackgroundFill(Color.rgb(28, 170, 23, 0.8), null, null)));
            VistaMazo vistaMazo = new VistaMazo(juego.mazo, juego, mazo);
            vistaMazo.actualizarVista();
            HBox waste = (HBox) mazoYWasteDisplay.lookup("#waste");
            //waste.setMinSize(mazoYWasteDisplay.getHeight(), mazoYWasteDisplay.getWidth() / 3 * 2);
            waste.setBackground(new Background(new BackgroundFill(Color.rgb(10, 50  , 180   , 1.0), null, null)));
            VistaWaste vistaWaste = new VistaWaste(juego.waste, juego, waste);
            vistaWaste.actualizarVista();
            HBox foundationsDisplay = (HBox) topDisplay.lookup("#foundations");
            foundationsDisplay.setBackground(new Background(new BackgroundFill(Color.rgb(180, 0, 0, 0.8), new CornerRadii(0.8), null)));
            //foundationsDisplay.setSpacing(-40);
            for(int i = 0; i < 4; i++){
                Pane foundation = new Pane();
                /*foundation.setMinHeight(foundationsDisplay.getHeight());
                foundation.setMinWidth(foundationsDisplay.getWidth() / 4);*/
                foundation.prefWidthProperty().bind(foundationsDisplay.widthProperty().divide(4));
                foundation.prefHeightProperty().bind(foundationsDisplay.heightProperty());
                foundation.setBackground(new Background(new BackgroundFill(Color.rgb(180, 180, 180, 1), new CornerRadii(0.8), null)));
                //foundation.getChildren().add(new Label("foundation " + i ));
                VistaFoundation vista = new VistaFoundation(juego.foundation.get(i), juego, i, foundation);
                vista.actualizarVista();
                foundationsDisplay.getChildren().add(foundation);
            }
            HBox pilonesDisplay = (HBox) tableauDisplay.lookup("#pilones");
            pilonesDisplay.setBackground(new Background(new BackgroundFill(Color.rgb(180, 180, 0, 0.8), new CornerRadii(0.8), null)));

            for(int i = 0; i < 7; i++){
                VBox pilonColumna = new VBox();
                /*foundation.setMinHeight(foundationsDisplay.getHeight());
                foundation.setMinWidth(foundationsDisplay.getWidth() / 4);*/
                pilonColumna.prefWidthProperty().bind(pilonesDisplay.widthProperty().divide(7));
                pilonColumna.prefHeightProperty().bind(pilonesDisplay.heightProperty());
                pilonColumna.setBackground(new Background(new BackgroundFill(Color.rgb(60, 60, 60, 1), new CornerRadii(0.8), null)));
                //foundation.getChildren().add(new Label("foundation " + i ));
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
