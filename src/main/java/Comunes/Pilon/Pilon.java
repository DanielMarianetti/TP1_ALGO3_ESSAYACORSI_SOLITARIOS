package Comunes.Pilon;

import Comunes.Carta.Carta;
import Movimientos.Movimiento;

public abstract class Pilon {

    public Movimiento movimiento;

    public Pilon(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public abstract Carta getUltimaCarta();

    public abstract Carta getPrimeraCarta();

    public abstract Carta getCarta(int i);

    public abstract boolean isPilonVacio();

    public abstract int cantidadCartas();

    public void mover(int altura, Pilon pilonDestino){
        this.movimiento.mover(altura,this, pilonDestino);
    }

    public abstract void recibirCarta(Carta carta);

    public abstract Carta sacarCarta(int i);

    /*
    * public List<Carta> cartas;
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
    }*/

    public abstract boolean cumpleCon(Movimiento movimientoControl, int cantidadSecuencia);
/*
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
    * */
}
