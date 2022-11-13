package edu.fiuba.algo3.modelo;

public interface TipoCasillero {

    public void pasarTurno();
    public String nombreDelCasillero();

    void extraerMineral(Inventario inventario, int cantidad) throws Exception;
}
