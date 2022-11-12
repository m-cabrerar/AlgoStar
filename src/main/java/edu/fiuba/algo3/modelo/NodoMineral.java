package edu.fiuba.algo3.modelo;

public class NodoMineral {
    private int unidadesRestantes = 0;
    public void extraerMineral(Inventario unDestinoDeRecoleccion, int cantidadRecolectada) {
        if(this.agotado()){
            return;
        }
        if (this.unidadesRestantes >= cantidadRecolectada){
            this.unidadesRestantes -= cantidadRecolectada;
            unDestinoDeRecoleccion.recibirMineral(cantidadRecolectada);
        }else{
            unDestinoDeRecoleccion.recibirMineral(this.unidadesRestantes);
            this.unidadesRestantes = 0;
        }
    }

    public boolean agotado(){
        return unidades == 0;
    }

}
