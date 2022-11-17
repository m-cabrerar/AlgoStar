package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public abstract class UnidadMovilProtoss extends UnidadMovil {
    int escudoMaximo;
    int escudo;
    int vida;

    UnidadMovilProtoss(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int escudoInicial){
        super(inventario, costoMineral, costoGas);
        this.vida = vidaInicial;
        this.escudo = escudoInicial;
        this.escudoMaximo = escudoInicial;
    }

    @Override
    public void pasarTurno() {
        if (escudo < (escudoMaximo-10)){
            escudo+=10;
        }
        else if( (escudo < escudoMaximo) && (escudo > (escudoMaximo-10)) ){
            escudo = escudoMaximo;
        }
    }
    abstract void atacar(UnidadMovil unidadAAtacar);
}
