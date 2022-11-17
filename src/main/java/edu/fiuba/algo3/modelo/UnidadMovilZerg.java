package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public abstract class UnidadMovilZerg extends UnidadConcreta {
    private final int vidaMaxima;
    private int vida;
    public UnidadMovilZerg(Casillero casillero_, Inventario inventario_, int vida_){
        super(casillero_, inventario_, vida_);
        vidaMaxima = vida_;
        vida = vida_;
    }
    public void recibirDanio(int danioTierra, int danioAire) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("La unidad fue destruida");
        }
        if(this.puedeVolar()){
            vida -= danioAire;
        } else {
            vida -= danioTierra;
        }
        if (estaDestruido()){
            casillero.desocupar();
        }
    }
    public void pasarTurno(){
        if (vida < (vidaMaxima-10)){
            vida+=10;
        }
        else if( (vida < vidaMaxima) && (vida > (vidaMaxima-10)) ){
            vida = vidaMaxima;
        }
    }
}
