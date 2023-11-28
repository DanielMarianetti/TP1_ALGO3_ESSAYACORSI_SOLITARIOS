import Interfaz.Vistas.VistaInicio;
import Interfaz.Vistas.VistaInicioJuego;
import javafx.application .Application;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) {

        stage.setWidth(888);
        stage.setHeight(600);
        stage.setResizable(false);

        VistaInicio vistaInicioJuego = new VistaInicio(stage);
        vistaInicioJuego.SetVistaInicial();
    }
}
