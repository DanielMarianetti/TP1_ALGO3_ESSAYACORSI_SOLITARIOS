package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Movimientos.Movimiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Mazo extends Pilon{
    public Stack<Carta> mazo;

    public Mazo(boolean ordenado, Movimiento movimiento) {
        super(movimiento);
        this.mazo = new Stack<>();
        for (Palo palo : Palo.values()) {
            for (Numero numero : Numero.values()) {
                Carta carta = new Carta(numero, palo);
                this.mazo.push(carta);
            }
        }
        if (!ordenado) {
            mezclar();
        }
    }

    public Mazo(Movimiento movimiento) {
        super(movimiento);
        this.mazo = new Stack<>();
    }

    @Override
    public void setCartas(List<Carta> cartas) {
        for(Carta carta : cartas) {
            mazo.push(carta);
        }
    }

    protected void mezclar() {
        Collections.shuffle(this.mazo);
    }

    @Override
    public Carta getUltimaCarta() {
        return this.mazo.peek();
    }

    @Override
    public Carta getPrimeraCarta() {
        return this.mazo.get(0);
    }

    @Override
    public Carta getCarta(int i) {
        return this.mazo.get(i);
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
    public void recibirCartas(List<Carta> cartasAgregar) {
        for(Carta carta : cartasAgregar) {
            mazo.push(carta);
        }
    }

    @Override
    public List<Carta> sacarPilon(int i) {
        List<Carta> cartas = new ArrayList<>();
        cartas.add(this.mazo.pop());
        return cartas;
    }

}
