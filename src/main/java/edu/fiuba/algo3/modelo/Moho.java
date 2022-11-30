package edu.fiuba.algo3.modelo;

import java.util.List;

public class Moho extends TipoCasillero {
    public Moho(){}
    @Override
    public void expandirMoho(List<Casillero> casillasAContagiar) {
        for (Casillero casilla : casillasAContagiar) {
            if (casilla.estaOcupado()) {
                return;
            }
            casilla.setTipoCasillero(new Moho());
        }
    }

    @Override
    public boolean ocupar (Unidad unidad){
        return true;
    }
    @Override
    public boolean ocupar (Criadero criadero){
        return true;
    }
}
