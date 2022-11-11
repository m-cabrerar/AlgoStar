package edu.fiuba.algo3.modelo;

abstract class EdificioProtoss extends EdificioConcreto {
    private int escudo;

    public void recibirDanio(int danio) {
        escudo -= danio;
        if (escudo < 0) {
            vida += escudo;
            escudo = 0;
        }
    }

    public void pasarTurno() {
        escudo += 10;
    }
}
