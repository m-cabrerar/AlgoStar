package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursoAgotado;
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
    public int extraerMineral(int cantidad) throws Exception {
        if (this.agotado()){
            throw new RecursoAgotado("Nodo Mineral Agotado, no es posible extraer");
            //return cantidad + unidadesRestantes;
        }
        unidadesRestantes -= cantidad;
        return cantidad;
    }
    public boolean agotado(){
        return unidadesRestantes <= 0;
    }
}