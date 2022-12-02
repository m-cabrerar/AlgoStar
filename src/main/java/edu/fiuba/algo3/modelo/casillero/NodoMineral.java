package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.unidades.edificios.NexoMineral;

public class NodoMineral extends TipoCasillero {
    private int unidadesRestantes;

    public NodoMineral(){
        unidadesRestantes = 2000;
    }


    @Override
    public int extraerMineral(int cantidad) {
        unidadesRestantes -= cantidad;
        if (this.agotado()){
            return cantidad + unidadesRestantes;
        }
        return cantidad;
    }
    public boolean agotado(){
        return unidadesRestantes <= 0;
    }

    @Override
    public boolean ocupar(NexoMineral nexo){
        return true;
    }

}