package Objetivos;

import Comunes.Pilon.Pilon;

import java.util.List;

public class PilonEnteroMismoPalo implements Objetivo {

    @Override
    public boolean cumplido(Pilon pilon){
        return true;
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
