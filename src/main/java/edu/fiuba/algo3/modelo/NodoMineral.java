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

    public boolean agotado(){
        return unidadesRestantes == 0;
    }
    @Override
    public void extraerMineral(Inventario unDestinoDeRecoleccion, int cantidadRecolectada){
        if(this.agotado()){
            return; //No recolecta nada.
        }
        if (this.unidadesRestantes >= cantidadRecolectada){
            this.unidadesRestantes -= cantidadRecolectada;
            unDestinoDeRecoleccion.recibirMineral(cantidadRecolectada);
        }else{
            unDestinoDeRecoleccion.recibirMineral(this.unidadesRestantes);
            this.unidadesRestantes = 0;
        }
    }
}