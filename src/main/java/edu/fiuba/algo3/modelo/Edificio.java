package edu.fiuba.algo3.modelo;

public interface Edificio {
    public void pasarTurno();
    public void recibirDanio(int danio) throws EstaDestruido;
}
