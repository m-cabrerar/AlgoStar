package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

import java.util.List;

public abstract class UnidadMovil implements Unidad, Construible {

    protected Casillero casillero;
    protected Inventario inventario;
    protected Superficie superficie;
    protected Vida vida;

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
        casillero = null;
        this.inventario = inventario;
    }

    public void ubicarEn(Casillero casillero){
        this.casillero = casillero;
        casillero.ocupar(this);
    }

    public boolean tieneEnRangoA(Unidad unidadAAtacar, int rango) {
        return (casillero.tieneEnRango(unidadAAtacar, rango));
    }

    public boolean estaPorAca(List<Casillero> casilleros){
        return casilleros.contains(casillero);
    }

    public boolean esVoladora(){
        return (superficie.puedeVolar());
    }
    public void recibirDanio(Danio danio) throws EstaDestruido {
        try {
            vida.sufrirAtaque(superficie.danio(danio));
        } catch (Exception EstaDestruido){
            casillero.desocupar();
            throw new EstaDestruido("Unidad destruida");
        }

    }

    public void atacar(UnidadMovil unidadAAtacar, int rango, Danio danio){
        if(!this.tieneEnRangoA(unidadAAtacar, rango)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        try{
            unidadAAtacar.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            throw new EstaDestruido("Unidad Destruida");
        }
    }


}
