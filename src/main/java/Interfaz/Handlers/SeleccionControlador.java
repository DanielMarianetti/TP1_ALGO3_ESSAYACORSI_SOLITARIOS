package Interfaz.Handlers;

import Comunes.Juego.Solitario;
import Interfaz.Vistas.VistasPrincipales.VistaPrincipal;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class SeleccionControlador {

    private List<Integer> movimiento;
    Solitario juego;
    VistaPrincipal vista;
    private Pane tempClickeado;

    public SeleccionControlador(Solitario juego, VistaPrincipal vista) {
        this.movimiento = new ArrayList<>();
        this.juego = juego;
        this.vista = vista;
    }

    public void handleClickPilon(int col, int alt, Pane panel) {
        setBaseMovimientoGUI(panel);

        this.movimiento.add(col);
        this.movimiento.add(alt);

        switch (movimiento.size()) {
            case 4:
                juego.moverPilonAPilon(movimiento.get(0), movimiento.get(1), movimiento.get(2));
                actualizar();
                break;
            case 3:
                juego.moverWasteAPilon(movimiento.get(1));
                actualizar();
                break;
            case 5:
                juego.moverFoundationAPilon(movimiento.get(0),movimiento.get(1),movimiento.get(3));
                break;
        }
        if (movimiento.size() > 2) {
            actualizar();
        }
    }

    public void handleClickFoundation(int col, int alt, Pane panel) {
        setBaseMovimientoGUI(panel);

        this.movimiento.add(col);
        this.movimiento.add(alt);
        this.movimiento.add(10);
        if (movimiento.size() > 5) {
            movimiento = new ArrayList<>();
        }

        if (this.movimiento.size() == 5) {
            juego.moverPilonAFoundation(movimiento.get(0), movimiento.get(1), movimiento.get(2));
            actualizar();
        } else if (movimiento.size() == 4) {
            juego.moverWasteAFoundation(movimiento.get(1));
            actualizar();
        }

    }

    public void handleClickWaste(Pane panel) {
        setBaseMovimientoGUI(panel);

        if (movimiento.size() > 1) {
            movimiento = new ArrayList<>();
        }
        movimiento.add(10);
    }

    public void actualizar() {
        this.movimiento = new ArrayList<>();
        vista.update();
    }

    private void setBaseMovimientoGUI(Pane panel){
        if(movimiento.isEmpty()){
            tempClickeado = panel;
            tempClickeado.setStyle("-fx-border-color: white; -fx-border-width: 3; -fx-border-style: solid;");
            tempClickeado.setEffect(new DropShadow(10, Color.WHITE));
        } else {
            tempClickeado = null;
        }
    }


}
