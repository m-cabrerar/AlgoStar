package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public abstract class UnidadMovilZerg extends UnidadMovil{
    int vidaMaxima;
    int vida;

    UnidadMovilZerg(Inventario inventario, int costoMineral, int costoGas, int vidaInicial){
        super(inventario, costoMineral, costoGas);
        this.vida = vidaInicial;
        this.vidaMaxima = vidaInicial;
    }

    @Override
    public void pasarTurno() {
        if (vida < (vidaMaxima-10)){
            vida+=10;
        }
        else if( (vida < vidaMaxima) && (vida > (vidaMaxima-10)) ){
            vida = vidaMaxima;
        }
    }

    abstract void atacar(UnidadMovil unidadAAtacar);
}
