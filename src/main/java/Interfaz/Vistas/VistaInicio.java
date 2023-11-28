package Interfaz.Vistas;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Handlers.InicioJuego;
import Interfaz.Vistas.Helpers.ObtensorImagenes;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class VistaInicio {

    private final Stage stage;

    public VistaInicio(Stage stage) {
        this.stage = stage;
        stage.setTitle("Solitario");
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();

            if(SolitarioPersistidor.getInstance().hayJuego()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Guardar partida actual?");
                alert.setHeaderText("Guardar?");

                ButtonType botonGuardar = new ButtonType("Guardar");
                ButtonType botonSalir = new ButtonType("Salir");

                alert.getButtonTypes().setAll(botonGuardar, botonSalir);

                // Show the alert and wait for the user's response
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == botonGuardar) {
                        SolitarioPersistidor.getInstance().saveState();
                    }
                    stage.close();
                });
            } else {
                stage.close();
            }
        });
    }
    public void SetVistaInicial() {
        BorderPane root = new BorderPane();

        Color backgroundColor = Color.rgb(28, 170, 23, 1.0);
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
        Background background = new Background(backgroundFill);
        Label bottomLabel = new Label("TP Solitarios");
        bottomLabel.setFont(new Font(16));
        StackPane footer = new StackPane(bottomLabel);
        footer.setAlignment(Pos.CENTER);
        footer.setBackground(background);

        VistaMenu vistaMenu = new VistaMenu(this);
        Control menu = vistaMenu.obtenerMenuBar();

        StackPane lienzo = new StackPane();
        lienzo.setAlignment(Pos.CENTER);
        lienzo.widthProperty().add(root.widthProperty());
        ObtensorImagenes.SettearImagenFondo(lienzo);
        //lienzo.setBackground(background);
        VBox buttonBox = new VBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        Button botonInicioJuego = new Button("Jugar");
        botonInicioJuego.setOnAction(new InicioJuego(lienzo));
        buttonBox.getChildren().add(botonInicioJuego);
        lienzo.getChildren().add(buttonBox);

        root.setCenter(lienzo);
        root.setTop(menu);
        root.setBottom(footer);

        Scene scene = new Scene(root, 900, 600);

        stage.setScene(scene);
        stage.setTitle("Solitario");
        stage.show();
    }
}
