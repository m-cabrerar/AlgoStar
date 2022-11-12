package edu.fiuba.algo3.modelo;

import java.lang.invoke.CallSite;

abstract class EdificioProtoss extends EdificioConcreto {
    private int escudo;
    private Casillero casillero;
    private Inventario inventario;

    public EdificioProtoss(Casillero unCasillero, Inventario unInventario){
        this.casillero=unCasillero;
        this.inventario=unInventario;
    }

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
