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
    public void extraerGas(Inventario unDestinoDeRecoleccion, int cantidadRecolectada) {
        if(this.agotado()){
            return; //no recolecta nada.
        }
        if (this.unidadesRestantes >= cantidadRecolectada){
            this.unidadesRestantes -= cantidadRecolectada;
            unDestinoDeRecoleccion.recibirGas(cantidadRecolectada);
        }else{
            unDestinoDeRecoleccion.recibirGas(this.unidadesRestantes);
            this.unidadesRestantes = 0;
        }
    }
    public boolean agotado(){
        return unidadesRestantes == 0;
    }
}
