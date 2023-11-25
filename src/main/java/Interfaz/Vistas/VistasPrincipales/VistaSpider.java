package Interfaz.Vistas.VistasPrincipales;

import Comunes.Juego.Klondike;
import Comunes.Juego.Spider;
import javafx.scene.layout.Pane;

public class VistaSpider implements VistaPrincipal {

    private Spider juego;
    private Pane lienzo;

    public VistaSpider(Spider juego, Pane lienzo) {
        this.juego = juego;
        this.lienzo = lienzo;
    }
    @Override
    public void cargar() {}
}
