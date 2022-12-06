package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class Moho extends TipoCasillero {
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
    public void ocupar (Unidad unidad){
        return;
    }
    @Override
    public void ocupar (Criadero criadero){
        return;
    }
}
