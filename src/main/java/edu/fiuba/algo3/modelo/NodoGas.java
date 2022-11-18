package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursoAgotado;
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
        if (this.agotado()){
            throw new RecursoAgotado("Nodo Gas Agotado, no es posible extraer");
            //return cantidad + unidadesRestantes;
        }
        unidadesRestantes -= cantidad;
        return cantidad;
    }
    public boolean agotado(){
        return unidadesRestantes <= 0;
    }

    @Override
    public boolean cumpleCondicionesEspeciales(UnidadMovil unidad){return false;}
}
