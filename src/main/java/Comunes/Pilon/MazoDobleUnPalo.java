package Comunes.Pilon;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Carta.Palo;
import Movimientos.Movimiento;

import java.util.Stack;

public class MazoDobleUnPalo extends Mazo {

    public MazoDobleUnPalo(boolean ordenado, Movimiento movimiento) {
        super(movimiento);
        this.mazo = new Stack<>();
        for (int i = 0; i < 8; i++) {
            for (Numero numero : Numero.values()) {
                Carta carta = new Carta(numero, Palo.PICA);
                this.mazo.push(carta);
            }
        }
        if (!ordenado) {
            super.mezclar();
        }
    }

}
