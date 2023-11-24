package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Columna extends Pilon {

    List<Carta> columna;

    public Columna(Movimiento movimiento) {
        super(movimiento);
        this.columna = new ArrayList<>();
    }

    public Columna(Movimiento movimiento, List<Carta> cartas) {
        super(movimiento);
        setCartas(cartas);
    }

    @Override
    public void setCartas(List<Carta> cartas){
        columna = cartas;
    }

    @Override
    public Carta getUltimaCarta() {
        if (this.isPilonVacio()) {
            return null;
        }
        return this.columna.get(this.columna.size()-1);
    }

    @Override
    public Carta getPrimeraCarta() {
        return this.getCarta(0);
    }

    @Override
    public Carta getCarta(int i) {
        return this.columna.get(i);
    }

    @Override
    public int cantidadCartas() {
        return this.columna.size();
    }

    @Override
    public boolean isPilonVacio() {
        return this.columna.isEmpty();
    }

    @Override
    public void recibirCartas(List<Carta> cartasAgregar) {
        if (cartasAgregar == null) {
            return;
        }
        columna.addAll(cartasAgregar);
        notifyObservers();
    }

    @Override
    public List<Carta> sacarPilon(int indice) {
        if (indice >= this.cantidadCartas() || !this.getCarta(indice).isBocaArriba()) {
            return null;
        }

        boolean validado;
        List<Carta> cartas = new ArrayList<>();

        if (cantidadCartas() == 1 || indice == this.cantidadCartas() - 1) {
            cartas.add(this.columna.remove( indice));
            return cartas;
        }

        for (int i = indice; i < this.cantidadCartas() - 1; i++) {
            Carta cartaActual = this.getCarta(i);
            Carta cartaSiguiente = this.getCarta(i+1);

            validado = this.movimiento.esSiguiente(cartaActual.getPalo(), cartaActual.getNumero(), cartaSiguiente);
            if (!validado) {
                return null;
            }
            cartas.add(cartaActual);
        }

        cartas.add(this.getUltimaCarta());

        List<Carta> cartasEliminar = columna.subList(indice, columna.size());
        columna.removeAll(cartasEliminar);
        notifyObservers();
        return cartas;
    }

}
