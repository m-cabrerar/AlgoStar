package edu.fiuba.algo3.modelo;

public class NexoMineral extends EdificioProtoss {
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario);
    }

    public void extraerMineral() {
        casillero.extraerMineral();
    }
}
