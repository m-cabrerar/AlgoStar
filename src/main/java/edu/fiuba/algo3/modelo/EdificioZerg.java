/*
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

abstract class EdificioZerg extends EdificioConcreto {
    private final int vidaMaxima;
    private int vida;
    public EdificioZerg(Casillero casillero_, Inventario inventario_, int vida_){
        super(casillero_, inventario_, vida_);
        vidaMaxima = vida_;
        vida = vida_;
    }
    public void recibirDanio(int danio) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        vida -= danio;
        if (estaDestruido()){
            casillero.desocupar();
        }
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

 */