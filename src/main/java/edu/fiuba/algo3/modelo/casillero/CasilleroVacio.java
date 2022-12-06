package edu.fiuba.algo3.modelo.casillero;


import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;

public class CasilleroVacio extends TipoCasillero{
    @Override
    public void ocupar (Unidad unidad){
        return;
    }

    @Override
    public void ocupar (Criadero criadero){
        return;
    }
}


