package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Pilon {

    public List<Carta> lista;
    public Movimiento movimiento;

    public Pilon() {
        this.lista = new ArrayList<>();
    }

    public Carta getUltimaCarta() {
        if (!this.lista.isEmpty()) {
            return this.lista.get(this.lista.size()-1);
        }
        return null;
    }

    public Carta getPrimeraCarta() {
        if (!this.lista.isEmpty()) {
            return this.lista.get(0);
        }
        return null;
    }

    public Carta getCarta(int i) {
        return lista.get(i);
    }

    public boolean isPilonVacio() {
        return this.lista.isEmpty();
    }

    public void recibirCarta(Carta carta) {
        this.lista.add(carta);
    }

    public  Carta sacarCarta() {
        return this.lista.remove(this.lista.size()-1);
    }

}
