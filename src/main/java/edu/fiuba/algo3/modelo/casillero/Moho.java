package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.unidades.edificios.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class Moho extends TipoCasillero {
    @Override
    public void expandirMoho(List<Casillero> casillasAContagiar) {
        for (Casillero casilla : casillasAContagiar) {
            if (casilla.estaOcupado()) {
                continue;
            }
            int posx = casilla.posicionX();
            int posy = casilla.posicionY();
            System.out.println("Se contagia: " + posx + posy);
            casilla.volverseMoho();
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
    @Override
    public void ocupar (ReservaDeReproduccion reservaDeReproduccion){
        return;
    }
    @Override
    public void ocupar (Guarida guarida){
        return;
    }
    @Override
    public void ocupar (Espiral espiral){
        return;
    }

}
