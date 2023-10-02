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
    public int getLength() {
        return this.columna.size();
    }

    @Override
    public boolean isPilonVacio() {
        return this.columna.isEmpty();
    }

    @Override
    public void recibirCarta(Carta carta) {
        this.columna.add(carta);
    }

    @Override
    public Carta sacarCarta(int i) {
        return this.columna.remove(i);
    }

}
