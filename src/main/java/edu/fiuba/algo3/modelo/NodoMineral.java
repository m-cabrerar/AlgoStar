package edu.fiuba.algo3.modelo;

public class NodoMineral implements TipoCasillero {
    private int unidadesRestantes = 0;
    public void extraerMineral(Inventario unDestinoDeRecoleccion, int cantidadRecolectada) throws Exception {
        if(this.agotado()){
            throw new Exception("Nodo Mineral Agotado, no es posible extraer");
            //return;
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
