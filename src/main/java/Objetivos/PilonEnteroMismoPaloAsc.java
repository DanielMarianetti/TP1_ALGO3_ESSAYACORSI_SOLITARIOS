package Objetivos;

import Comunes.Pilon.Pilon;

import java.util.List;

public class PilonEnteroMismoPaloAsc implements Objetivo {

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
