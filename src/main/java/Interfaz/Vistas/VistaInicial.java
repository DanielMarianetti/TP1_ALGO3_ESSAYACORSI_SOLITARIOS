package Interfaz.Vistas;

import Interfaz.BibliotecaJuegos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicial {

    private Stage stage;

    private BorderPane root;

    public VistaInicial(Stage stage) {
        this.stage = stage;
    }

    public void SetVistaInicial() {
        root = new BorderPane();

        Color backgroundColor = Color.rgb(28, 170, 23, 0.8);
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);

        Label bottomLabel = new Label("Text");
        bottomLabel.setFont(new Font(16));
        StackPane footer = new StackPane(bottomLabel);
        footer.setAlignment(Pos.CENTER);
        footer.setBackground(background);

        VistaMenu vistaMenu = new VistaMenu(this);
        Control menu = vistaMenu.obtenerMenuBar();

        StackPane lienzo = new StackPane();
        var bibJuegos = new BibliotecaJuegos(lienzo, this);
        var botonesJuegos = bibJuegos.getBotonesJuegos();
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setBackground(background);
        buttonBox.setMaxSize(400, 300);
        buttonBox.getChildren().addAll(botonesJuegos);
        lienzo.getChildren().add(buttonBox);

        root.setCenter(lienzo);
        root.setTop(menu);
        root.setBottom(footer);

        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Solitario");
        stage.show();
    }

    public void notificar(Node display){
        root.setCenter(display);
    }
}
