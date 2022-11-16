package edu.fiuba.algo3.modelo;

public class NodoGas extends TipoCasillero {
    int unidadesRestantes = 2000;
    @Override
    public void pasarTurno() {
    }
    @Override
    public String nombreDelCasillero() {
        return null;
    }

    public void extraerGas(int cantidadDeGas) {
        unidadesRestantes -= cantidadDeGas;
    }
}