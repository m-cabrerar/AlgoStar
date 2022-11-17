package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public abstract class UnidadMovil implements Unidad {
    @Override
    public void pasarTurno() {

    }
    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }
    abstract int turnosParaConstruir();

    public boolean esVoladora() {
        return false;
    }
}
