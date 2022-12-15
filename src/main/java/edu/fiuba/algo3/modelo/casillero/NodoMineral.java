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
            int cantidadADevolver = cantidad + unidadesRestantes;
            unidadesRestantes = 0;
            return cantidadADevolver;
        }
        return cantidad;
    }
    public boolean agotado(){
        return unidadesRestantes <= 0;
    }

    @Override
    public void ocupar(NexoMineral nexo){
        return;
    }

}