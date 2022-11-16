package edu.fiuba.algo3.modelo;

abstract class EdificioZerg extends EdificioConcreto {

    public EdificioZerg(Casillero casillero_, Inventario inventario_, int vida_){
        super(casillero_, inventario_, vida_);
    }

    public void regenerarVida(){
        vida += 10;
    }
}