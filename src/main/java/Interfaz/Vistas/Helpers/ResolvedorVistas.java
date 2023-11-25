package Interfaz.Vistas.Helpers;

import Comunes.Juego.Klondike;
import Comunes.Juego.Solitario;
import Comunes.Juego.Spider;
import Comunes.Persistencia.SolitarioPersistidor;
import Interfaz.Vistas.VistasPrincipales.VistaBibliotecaJuegos;
import Interfaz.Vistas.VistasPrincipales.VistaKlondike;
import Interfaz.Vistas.VistasPrincipales.VistaPrincipal;
import Interfaz.Vistas.VistasPrincipales.VistaSpider;
import javafx.scene.layout.Pane;

public class ResolvedorVistas {

    public static VistaPrincipal SetVista(Solitario juegoActual, Pane lienzo) {

        Klondike juegoKlondike;
        Spider juegoSpider;

        if(juegoActual != null){
            SolitarioPersistidor.getInstance().setJuego(juegoActual);
            VistaPrincipal vista;
            try{
                juegoSpider = (Spider) juegoActual;
                vista = new VistaSpider(juegoSpider, lienzo);
            } catch (ClassCastException ex) {
                juegoKlondike = (Klondike) juegoActual;
                vista = new VistaKlondike(juegoKlondike, lienzo);
            }
            return vista;
        } else {
            System.out.println("Devuelvo VistaBibliotecaJuegos");
            return new VistaBibliotecaJuegos(lienzo);
        }
    }
}
