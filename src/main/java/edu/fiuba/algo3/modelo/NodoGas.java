package edu.fiuba.algo3.modelo;


public class NodoGas extends TipoCasillero{
    private int unidadesRestantes;

    public NodoGas(){
        unidadesRestantes = 5000;
    }
    @Override
    public String nombreDelCasillero() {
        return "Nodo";
    }
    @Override
    public int extraerGas(int cantidad) {
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
    public boolean cumpleCondicionesEspeciales(UnidadMovil unidad){return false;}
}
