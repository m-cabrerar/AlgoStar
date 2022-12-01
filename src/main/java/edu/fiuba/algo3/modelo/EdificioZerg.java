package edu.fiuba.algo3.modelo;


abstract class EdificioZerg extends EdificioConcreto {
    public EdificioZerg(Casillero casillero, Inventario inventario, int vida){
        super(casillero, inventario);
        this.vida = new VidaZerg(vida);
    }
    public void pasarTurno(){
        super.pasarTurno();
        this.vida.pasarTurno();
    }
}