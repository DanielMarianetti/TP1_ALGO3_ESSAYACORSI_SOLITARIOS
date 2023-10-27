package Comunes.Juego;

import Comunes.Pilon.Mazo;
import Comunes.Pilon.Pilon;
import Movimientos.*;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public abstract class Solitario implements Serializable {

    public List<Pilon> tableau;
    public Pilon mazo;
    public List<Pilon> foundation;
    public Pilon waste;
    public boolean juegoComenzado = false;

    public boolean juegoGanado = false;

    public Solitario() {
        this.tableau = new ArrayList<>();
        this.foundation = new ArrayList<>();
        this.waste = new Mazo(new MovimientoLibre());
    }

    ///Crea un juego random
    public void iniciarRandom() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new Mazo(false, movimiento);
        this.setJuego();
        this.setJuegoComenzado(true);
    }

    ///Deja el juego listo para empezar a ser jugado a partir de un mazo ordenado
    public void iniciarOrdenado() {
        Movimiento movimiento = new MovimientoLibre();
        this.mazo = new Mazo(true, movimiento);
    }

    //Cambia el estado a comenzado para que no se puedan hacer mas moviminetos libres
    //Solo se pueden hacer los movimientos que dependen del tipo de solitario
    public void setJuegoComenzado(boolean juegoComenzado) {
        if (juegoComenzado) {
            for (Pilon columna : this.tableau) {
                if (!columna.isPilonVacio()) {
                    columna.getUltimaCarta().setBocaArriba(true);
                }
            }
        }
        this.juegoComenzado = juegoComenzado;
    }

    public void movimientoLibre(int columna) {
        if (!this.juegoComenzado) {
            this.mazo.mover(this.mazo.cantidadCartas() - 1, this.tableau.get(columna));
            this.tableau.get(columna).getUltimaCarta().setBocaArriba(true);
        }
    }

    //Prepara cuantas cartas van a cada pila, depende de cada solitario
    public abstract void setJuego();

    //El objetivo a completar depende del tipo de solitario
    public abstract boolean juegoGanado();

    public abstract void moverMazoAWaste();

    public abstract void rearmarMazo();

    public abstract void moverWasteAPilon(int colunma);

    public abstract void moverWasteAFoundation(int foundation);

    public abstract void moverPilonAPilon(int columnaOrigen, int altura, int columnaDestino);

    public abstract void moverPilonAFoundation(int columnaOrigen, int altura, int foundationDestino);

    public abstract void moverFoundationAPilon(int foundationOrigen, int altura, int columnaDestino);

    public void serializar(OutputStream os) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(this);
        objectOutputStream.flush();
    }

    public static Solitario deserializar(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        return (Solitario) objectInputStream.readObject();
    }
}