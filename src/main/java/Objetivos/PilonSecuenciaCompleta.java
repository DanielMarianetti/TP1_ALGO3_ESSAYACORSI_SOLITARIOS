package Objetivos;

import Comunes.Carta.Carta;
import Comunes.Carta.Numero;
import Comunes.Pilon.Pilon;
import Movimientos.MismoPaloDescendente;

import java.util.List;

public class PilonSecuenciaCompleta implements Objetivo{

    @Override
    public boolean cumplido(Pilon c) {
        int cant = 0;
        if (c.cantidadCartas() >= 13 & c.getUltimaCarta().getNumero() == Numero.AS) {
            c.setMovimiento(new MismoPaloDescendente());
            List<Carta> f = c.sacarPilon(c.cantidadCartas()-13);
            if (f != null) {
                cant = f.size();
                c.recibirCartas(f);
            }
        }
        return cant == 13;
    }

    @Override
    public boolean cumplido(List<Pilon> columnas) {
        for (Pilon columna : columnas) {
            if (!cumplido(columna)) {
                return false;
            }
        }
        return true;
    }
}
