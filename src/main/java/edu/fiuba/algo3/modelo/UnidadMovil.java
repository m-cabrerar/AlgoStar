package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

public abstract class UnidadMovil implements Unidad {
    UnidadMovil(Inventario inventario, int costoMineral, int costoGas){
        if(!inventario.tieneRecursos(costoMineral, costoGas)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
    }

    abstract int turnosParaConstruir();

    public boolean esVoladora() {
        return false;
    }

    abstract void atacar(UnidadMovil unidadAAtacar);
}
