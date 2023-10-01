package Objetivos;

import Comunes.Pilon.Pilon;

import java.util.List;

public interface Objetivo {

    boolean cumplido(Pilon pilon);

    boolean cumplido(List<Pilon> pilon);
}
