package edu.fiuba.algo3.modelo;

public class NodoMineral extends TipoCasillero{
    private int unidadesRestantes;

    public NodoMineral(){
        unidadesRestantes = 2000;
    }
    @Override
    public String nombreDelCasillero() {
        return "NodoMineral";
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
}