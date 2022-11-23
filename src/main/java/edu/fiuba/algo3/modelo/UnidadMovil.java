package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

import java.util.List;

public abstract class UnidadMovil implements Unidad {

    Casillero casilleroActual;
    Inventario inventario;
    UnidadMovil(Inventario inventario, int costoMineral, int costoGas, int costoSuministro){
        if(!inventario.tieneRecursos(costoMineral, costoGas)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneSuministros(costoSuministro)){
            throw new SuministrosInsuficientes("No tiene suministros");
        }
        if(!inventario.puedeCrecerPoblacion(costoSuministro)){
            throw new PoblacionMaximaAlcanzada("No se pueden crear mas unidades.");
        }
        inventario.suministrarUnidad(costoSuministro);
        casilleroActual = null;
        this.inventario = inventario;
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
