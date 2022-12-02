package edu.fiuba.algo3.modelo.casillero;


import edu.fiuba.algo3.modelo.unidades.Unidad;

public class CasilleroVacio extends TipoCasillero{
    @Override
    public boolean ocupar (Unidad unidad){
        return true;
    }
}

