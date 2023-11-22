package Interfaz.Vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.util.Optional;

public class VistaMenu {

    private VistaInicial vistaInicial;

    public VistaMenu(VistaInicial inicial) {
        vistaInicial = inicial;
    }

    public Control obtenerMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Opciones"); //TODO
        MenuItem selectConfig = new MenuItem("Configuracion"); //TODO
        MenuItem selectAbout = new MenuItem("Acerca");

        MenuItem selectMainMenu = new MenuItem("Volver al inicio");
        selectMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Volver al inicio");
                alert.setHeaderText("Si vuelve al inicio se guardara el progreso de la partida actual");
                //alert.setContentText("Volver para continuar");

                ButtonType seleccionSi = new ButtonType("Volver", ButtonBar.ButtonData.YES);
                ButtonType seleccionNo = new ButtonType("Cancelar", ButtonBar.ButtonData.NO);
                alert.getButtonTypes().setAll(seleccionSi, seleccionNo);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == seleccionSi) {
                    vistaInicial.SetVistaInicial();
                }
            }
        });

        menu.getItems().addAll(selectConfig, selectAbout, selectMainMenu);
        menuBar.getMenus().add(menu);

        return menuBar;
    }
}
