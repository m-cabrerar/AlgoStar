package edu.fiuba.algo3.modelo;

abstract class EdificioProtoss extends EdificioConcreto {

    public EdificioProtoss(Casillero unCasillero, Inventario unInventario, int vidaInicial, int escudoInicial){
        super(unCasillero, unInventario);
        this.vida = new VidaProtoss(vidaInicial, escudoInicial);
    }

    public void pasarTurno(){
        super.pasarTurno();
        this.vida.pasarTurno();
    }
}
