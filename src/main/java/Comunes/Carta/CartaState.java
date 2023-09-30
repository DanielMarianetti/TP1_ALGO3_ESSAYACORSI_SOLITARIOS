package Comunes.Carta;

import Movimientos.Movimiento;

public interface CartaState {

    boolean colocarSobre(Carta otraCarta, Movimiento movimiento);

    void ultimaPilon();

    void traerAlMazo();
}
