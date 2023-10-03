package Comunes.Carta;

import Movimientos.Movimiento;

public interface CartaState {

    public boolean tomar();

    void pedirDelMazo();

    void ultimaPilon();

    void traerAlMazo();

    String mostrarEstado();
}
