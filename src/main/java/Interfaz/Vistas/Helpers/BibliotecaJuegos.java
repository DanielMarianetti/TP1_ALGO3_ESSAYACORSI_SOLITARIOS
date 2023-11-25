package Interfaz.Vistas.Helpers;

import Interfaz.Handlers.InicializadorKlondike;
import Interfaz.Handlers.InicializadorSpider;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaJuegos {

    private final Pane lienzo;

    public BibliotecaJuegos(Pane lienzo){
        this.lienzo = lienzo;
    }

    public List<Button> getBotonesJuegos() {

        List<Button> botones = new ArrayList<>();

        botones.add(new InicializadorKlondike(lienzo));
        botones.add(new InicializadorSpider(lienzo));

        return botones;
    }
}
