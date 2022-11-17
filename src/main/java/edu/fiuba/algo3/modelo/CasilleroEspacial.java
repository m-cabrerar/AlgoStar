package edu.fiuba.algo3.modelo;

public class CasilleroEspacial extends TipoCasillero {
    @Override
    public String nombreDelCasillero() {
        return "Casillero Espacial";
    }


    public boolean cumpleCondicionesEspeciales(Unidad unidad){return unidad.esVoladora();}
}
