package edu.fiuba.algo3.modelo;

abstract class EdificioZerg extends EdificioConcreto {
    public void pasarTurno() {
        vida += 10;
    }
}