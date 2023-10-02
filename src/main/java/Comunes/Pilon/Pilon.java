package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Pilon {

    public List<Carta> cartas;
    public Movimiento movimiento;

    public Pilon() {
        this.cartas = new ArrayList<>();
    }
    public Pilon(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Pilon(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Carta getUltimaCarta() {
        if (!this.cartas.isEmpty()) {
            return this.cartas.get(this.cartas.size()-1);
        }
        return null;
    }

    public Carta getPrimeraCarta() {
        if (!this.cartas.isEmpty()) {
            return this.cartas.get(0);
        }
        return null;
    }

    public Carta getCarta(int i) {
        return cartas.get(i);
    }

    public boolean cumpleCon(Movimiento movimientoControl, int cantidadSecuencia) {
        for (int i = 0; i <= cartas.size() - cantidadSecuencia; i++) {
            boolean secuenciaHallada = true;
            for (int j = 0; j < cantidadSecuencia; j++) {
                if (!cartas.get(i + j).esSiguiente(cartas.get(i + j + 1), movimientoControl)) {
                    secuenciaHallada = false;
                    break;
                }
            }
            if (secuenciaHallada) {
                return true;
            }
        }
        return false;
    }

    public int cantidadCartas(){
        return cartas.size();
    }

    public boolean isPilonVacio() {
        return this.cartas.isEmpty();
    }

    public List<Carta> apilarSobre(List<Carta> cartasBase){
        cartasBase.addAll(this.cartas);
        return cartasBase;
    }

    public boolean agregar(Pilon pilon) {
        if(this.getUltimaCarta().esSiguiente(pilon.getPrimeraCarta(), movimiento)) {
            this.cartas = pilon.apilarSobre(this.cartas);
            return true;
        }
        return false;
    }

    public boolean agregar(Carta carta) {
        if(this.getUltimaCarta().esSiguiente(carta, movimiento)) {
            this.cartas.add(carta);
            return true;
        }
        return false;
    }

    public  Carta sacarCarta() {
        return this.cartas.remove(this.cartas.size()-1);
    }

    public Pilon sacarPilon(Carta cartaBase) {
        int indiceCarta = -1;
        Pilon tomado = new Pilon();

        if(cartaBase.tomar()){
            indiceCarta = this.cartas.indexOf(cartaBase);
        }

        if(indiceCarta != -1){
            List<Carta> cartasSacar = cartas.subList(indiceCarta, this.cartas.size());
            cartas.removeAll(cartasSacar);
            tomado = new Pilon(cartasSacar);
        }

        return tomado;
    }

}
