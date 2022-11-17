package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

import java.util.List;

public abstract class UnidadMovil implements Unidad {

    Casillero casilleroActual;
    UnidadMovil(Inventario inventario, int costoMineral, int costoGas){
        if(!inventario.tieneRecursos(costoMineral, costoGas)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        casilleroActual = null;
    }

    abstract int turnosParaConstruir();

    public boolean esVoladora() {
        return false;
    }

    abstract void atacar(UnidadMovil unidadAAtacar);

    public void ubicarEn(Casillero casillero){
        casilleroActual = casillero;
    }

    public boolean tieneEnRangoA(Unidad unidadAAtacar, int rango) {
        return (casilleroActual.tieneEnRango(unidadAAtacar, rango));
    }

    public boolean estaPorAca(List<Casillero> casilleros){
        return casilleros.contains(casilleroActual);
    }
}
