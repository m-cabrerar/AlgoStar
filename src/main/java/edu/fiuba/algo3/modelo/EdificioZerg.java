package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

abstract class EdificioZerg extends EdificioConcreto {
    private final int vidaMaxima;
    public EdificioZerg(Casillero casillero_, Inventario inventario_, int vida_){
        super(casillero_, inventario_, vida_);
        vidaMaxima = vida_;
    }

    public void pasarTurno(){
        super.pasarTurno();
        if (vida < (vidaMaxima-10)){
            vida+=10;
        }
        else if( (vida < vidaMaxima) && (vida > (vidaMaxima-10)) ){
            vida = vidaMaxima;
        }
    }
}