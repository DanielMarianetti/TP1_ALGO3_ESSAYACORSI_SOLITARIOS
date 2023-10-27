package Objetivos;

import Comunes.Pilon.Pilon;

import java.io.Serializable;
import java.util.List;

public class PilonEnteroMismoPaloAsc implements Objetivo, Serializable {

    @Override
    public boolean cumplido(Pilon foundation) {
        return foundation.cantidadCartas() == 13;
    }

    @Override
    public boolean cumplido(List<Pilon> foundations){
        for (Pilon foundation : foundations) {
            if (!cumplido(foundation)) {
                return false;
            }
        }
        return true;
    }
}
