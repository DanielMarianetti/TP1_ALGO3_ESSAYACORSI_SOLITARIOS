package Interfaz.Vistas;

import Comunes.Juego.Klondike;
import Comunes.Persistencia.SolitarioPersistidor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.util.Optional;

public class VistaMenu {

    private VistaInicio vistaInicio;

    public VistaMenu(VistaInicio inicial) {
        vistaInicio = inicial;
    }

    public Control obtenerMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        //MenuItem selectConfig = new MenuItem("Configuracion"); //TODO
       // MenuItem selectAbout = new MenuItem("Acerca");

        MenuItem selectMainMenu = new MenuItem("Volver al inicio");
        selectMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Volver al inicio");
                alert.setHeaderText("Desea guardar el progreso de la partida actual?");
                //alert.setContentText("Volver para continuar");

                ButtonType seleccionGuardar = new ButtonType("Guardar", ButtonBar.ButtonData.YES);
                ButtonType seleccionNoGuardar = new ButtonType("Volver sin guardar", ButtonBar.ButtonData.NO);
                ButtonType seleccionCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(seleccionGuardar, seleccionNoGuardar, seleccionCancelar);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == seleccionGuardar) {
                    SolitarioPersistidor.getInstance().saveState();
                    vistaInicio.SetVistaInicial();
                } else if(result.isPresent() && result.get() == seleccionNoGuardar) {
                    //Comentar esta linea que sigue si se desea que no se elimine el guardado en su totalidad
                    //sino que sólo los cambios que se hicieron desde la última sesión
                    SolitarioPersistidor.getInstance().eliminarGuardado();
                    vistaInicio.SetVistaInicial();
                }
            }
        });

        menu.getItems().addAll(selectMainMenu);
        menuBar.getMenus().add(menu);

        return menuBar;
    }
}
