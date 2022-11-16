package edu.fiuba.algo3.modelo;

public class NodoMineral implements TipoCasillero {
    private int unidadesRestantes = 0;

    public void extraerMineral(Inventario unDestinoDeRecoleccion, int cantidadRecolectada) throws Exception{
        if(this.agotado()){
            try {
                throw new Exception("Nodo Mineral Agotado, no es posible extraer");
            } catch (Exception e) {
                throw new RuntimeException(e); //maybe
            }
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
        return unidadesRestantes == 0;
    }

    @Override
    public void pasarTurno() {

    }

    @Override
    public String nombreDelCasillero() {
        return null;
    }
}