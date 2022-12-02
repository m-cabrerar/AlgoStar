package edu.fiuba.algo3.modelo.unidades.edificios;


import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.VidaZerg;

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