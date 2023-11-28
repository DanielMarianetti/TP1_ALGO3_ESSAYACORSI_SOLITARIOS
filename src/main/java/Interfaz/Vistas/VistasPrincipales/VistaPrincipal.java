package Interfaz.Vistas.VistasPrincipales;

import Comunes.Juego.Solitario;
import Interfaz.Vistas.Pilones.VistaPilon;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class VistaPrincipal implements Observer {
    protected Pane lienzo;
    protected List<VistaPilon> vistas;

    protected VistaPrincipal(Pane lienzo){
        this.lienzo = lienzo;
        this.vistas = new ArrayList<>();
    }

    public abstract void cargar();

    public abstract void update();

    @Override
    public void update(Observable o, Object arg) {
        Solitario juego = (Solitario) o;
        if(juego.juegoGanado){
            Label ganasteLabel = new Label("Ganaste!!");
            ganasteLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
            ganasteLabel.setTextFill(Color.WHITE);

            Label infoLabel = new Label("Puede utilizar el menú para iniciar una nueva partida");
            infoLabel.setFont(new Font(20));
            infoLabel.setTextFill(Color.WHITE);

            VBox cartel = new VBox(ganasteLabel, infoLabel);
            cartel.setSpacing(20);
            cartel.setAlignment(Pos.CENTER);

            lienzo.getChildren().clear();
            lienzo.getChildren().add(cartel);

        }
    }
}
