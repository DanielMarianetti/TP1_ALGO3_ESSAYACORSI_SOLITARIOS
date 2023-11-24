import Interfaz.BibliotecaJuegos;
import Interfaz.Vistas.VistaInicial;
import javafx.application .Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) {

        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);

        VistaInicial vistaInicial = new VistaInicial(stage);
        vistaInicial.SetVistaInicial();
    }
}
