package edu.fiuba.algo3.modelo;

public class NexoMineral extends EdificioProtoss {

    private int cantidadQueExtrae = 10;
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario);
    }

    public void extraerMineral(Inventario inventario) {
        this.casillero.extraerMineral(inventario, this.cantidadQueExtrae);
    }
}
