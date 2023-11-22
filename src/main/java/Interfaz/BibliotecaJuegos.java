package Interfaz;

import Interfaz.Handlers.InicializadorKlondike;
import Interfaz.Handlers.InicializadorSpider;
import Interfaz.Vistas.VistaInicial;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaJuegos {

    private Pane lienzo;

    private VistaInicial observer;

    public BibliotecaJuegos(Pane lienzo, VistaInicial observer){
        this.lienzo = lienzo;
        this.observer = observer;
    }

    public List<Button> getBotonesJuegos() {

        List<Button> botones = new ArrayList<>();

        botones.add(new InicializadorKlondike(lienzo, observer));
        botones.add(new InicializadorSpider(lienzo, observer));

        return botones;
    }
}
