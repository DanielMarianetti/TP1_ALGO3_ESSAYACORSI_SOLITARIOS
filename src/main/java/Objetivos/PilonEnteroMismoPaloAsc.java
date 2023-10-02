package Objetivos;

import Comunes.Pilon.Pilon;
import Movimientos.MismoPaloAscendente;
import Movimientos.MismoPaloDescendente;
import Movimientos.Movimiento;

import java.util.List;

public class PilonEnteroMismoPaloAsc implements Objetivo {

    @Override
    public boolean cumplido(Pilon pilon) {
        Movimiento movimientoChequeo = new MismoPaloAscendente();
        int PILON_MISMO_PALO = 12;
        return pilon.cumpleCon(movimientoChequeo, PILON_MISMO_PALO) && pilon.cantidadCartas() == PILON_MISMO_PALO;
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
