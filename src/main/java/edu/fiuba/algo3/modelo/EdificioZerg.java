package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

abstract class EdificioZerg extends EdificioConcreto {
    private final int vidaMaxima;
    public EdificioZerg(Casillero casillero_, Inventario inventario_, int vida_){
        super(casillero_, inventario_, vida_);
        this.vidaMaxima = vida_;
    }

    public void pasarTurno(){
        super.pasarTurno();
        if (this.vida < (vidaMaxima-10)){
            this.vida+=10;
        }
        else if (this.vida < vidaMaxima){
            this.vida = vidaMaxima;
        }
    }
}