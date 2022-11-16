package edu.fiuba.algo3.modelo;

public class NodoMineral extends TipoCasillero {
    private int unidadesRestantes = 0;

    public void extraerMineral(int cantidadDeMineral) {
        unidadesRestantes -= cantidadDeMineral;
    }

    public boolean agotado(){
        return unidadesRestantes == 0;
    }

    @Override
    public void pasarTurno() {

    }

    @Override
    public String nombreDelCasillero() {
        return null;
    }
}