package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;
import Movimientos.Movimiento;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Mazo extends Pilon{
    public Stack<Carta> mazo;

    public Mazo(boolean ordenado, Movimiento movimiento) {
        super(movimiento);
        this.mazo = new Stack<>();
        for (Palo palo : Palo.obtenerPalos()) {
            for (Numero numero : Numero.values()) {
                Carta carta = new Carta(numero, palo);
                this.mazo.push(carta);
            }
        }
        if (!ordenado) {
            Collections.shuffle(this.mazo);
        }
    }

    public Mazo(Movimiento movimiento) {
        super(movimiento);
        this.mazo = new Stack<>();
    }

    public Mazo(Movimiento movimiento, List<Carta> cartas) {
        super(movimiento);
        this.mazo = (Stack<Carta>) cartas;
    }

    @Override
    public void setCartas(List<Carta> cartas){
        mazo = (Stack<Carta>) cartas;
    }

    private void mezclar(Stack<Carta> cartas) {
        Collections.shuffle(cartas);
    }

    @Override
    public Carta getUltimaCarta() {
        return this.mazo.peek();
    }

    @Override
    public Carta getPrimeraCarta() {
        return null;
    }

    @Override
    public Carta getCarta(int i) {
        return this.mazo.remove(i);
    }

    @Override
    public boolean isPilonVacio() {
        return this.mazo.empty();
    }

    @Override
    public int cantidadCartas() {
        return this.mazo.size();
    }

    @Override
    public void recibirCarta(Carta carta) {
        this.mazo.push(carta);
    }

    @Override
    public Carta sacarCarta(int i) {
        return this.mazo.pop();
    }

    @Override
    public boolean cumpleCon(Movimiento movimientoControl, int cantidadSecuencia) {
        return false;
    }

}
