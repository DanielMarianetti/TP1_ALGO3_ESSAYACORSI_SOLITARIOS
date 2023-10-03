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
        this.columna = cartas;
    }

    @Override
    public void setCartas(List<Carta> cartas){
        columna = cartas;
    }

    @Override
    public Carta getUltimaCarta() {
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
        if(cartasAgregar != null) {
            columna.addAll(cartasAgregar);
        }
    }

    /*@Override
    public void recibirCarta(Carta carta) {
        this.columna.add(carta);
    }*/

    @Override
    public List<Carta> sacarPilon(int indice) {
        int indiceInicial = indice;

        if(indice >= this.cantidadCartas())
            return null;

        List<Carta> cartas = new ArrayList<>();
        Carta cartaActual = columna.get(indice);
        cartas.add(cartaActual);

        if(indice + 1 == this.cantidadCartas())
            return cartas;

        Carta cartaSiguiente;

        while(indice + 1 < this.cantidadCartas()){
            cartaSiguiente = columna.get(++indice);
            if(cartaActual.esSiguiente(cartaSiguiente, movimiento)){
                cartaActual = cartaSiguiente;
                cartas.add(cartaActual);
            } else {
                return null;
            }
        }

        List<Carta> cartasEliminar = columna.subList(indiceInicial, columna.size());
        columna.removeAll(cartasEliminar);
        return cartas;
    }

    @Override
    public boolean cumpleCon(Movimiento movimientoControl, int cantidadSecuencia) {
        for (int i = 0; i <= columna.size() - cantidadSecuencia; i++) {
            boolean secuenciaHallada = true;
            for (int j = 0; j < cantidadSecuencia; j++) {
                if (!columna.get(i + j).esSiguiente(columna.get(i + j + 1), movimientoControl)) {
                    secuenciaHallada = false;
                    break;
                }
            }
            if (secuenciaHallada) {
                return true;
            }
        }
        return false;
    }
}
