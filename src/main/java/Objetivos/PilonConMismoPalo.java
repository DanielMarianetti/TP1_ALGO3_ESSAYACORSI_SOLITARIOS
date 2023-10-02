package Objetivos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Pilon.Pilon;
import Movimientos.MismoPaloDescendente;
import Movimientos.Movimiento;

import java.util.List;

public class PilonConMismoPalo implements Objetivo {

    @Override
    public boolean cumplido(Pilon pilon) {
        Movimiento movimientoChequeo = new MismoPaloDescendente();
        int PILON_MISMO_PALO = 12;
        return pilon.cumpleCon(movimientoChequeo, PILON_MISMO_PALO);
    }

    @Override
    public boolean cumplido(List<Pilon> pilones){
        boolean cumplido = true;
        int contador = 0;
        while(cumplido && contador < pilones.size()){
            cumplido = cumplido(pilones.get(contador));
            contador++;
        }
        return cumplido;
    }
}
