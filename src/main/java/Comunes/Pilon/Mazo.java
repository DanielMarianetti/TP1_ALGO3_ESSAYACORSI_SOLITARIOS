package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Palo.Palo;

import java.util.Collections;
import java.util.Stack;

public class Mazo extends Pilon{
    public Stack<Carta> mazo;

    // crea el mazo ordenado o desordenado
    public Mazo(boolean ordenado) {
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


    private void mezclar(Stack<Carta> cartas) {
        Collections.shuffle(cartas);
    }

    @Override
    public Carta getPrimeraCarta() {
        return  this.mazo.peek();
    }

    @Override
    public void recibirCarta(Carta carta) {
        this.mazo.push(carta);
    }

    @Override
    public Carta sacarCarta() {
        if (!this.mazo.empty()) {
            return this.mazo.pop();
        }
        return null;
    }
}
