package edu.fiuba.algo3.modelo;

public class Extractor implements EdificioZerg{
    int cantidadZanganos;
    int unidadesRecolectadasPorZangano;

    public void extraerGas(Inventario unInventario){
        int cantidadARecolectar = this.cantidadQueRecolecta();
        (this.suCasillero).extraerMineral(unInventario,cantidadARecolectar);
    }

    private int cantidadQueRecolecta(){
        return this.unidadesRecolectadasPorZangano * this.cantidadZanganos;
    }
}
