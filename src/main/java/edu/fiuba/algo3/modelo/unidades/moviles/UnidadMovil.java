package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.List;

public abstract class UnidadMovil implements Unidad, Construible {

    protected Casillero casillero;
    protected Inventario inventario;
    protected Superficie superficie;
    protected Vida vida;

    UnidadMovil(Inventario inventario, int costoMineral, int costoGas, int costoSuministro){
        if(!inventario.tieneRecursos(costoGas, costoMineral)){
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
        casillero.quitarInvisibilidadEnRango(1);
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

    public void atacar(Unidad unidadAAtacar, int rango, Danio danio){
        if(!this.tieneEnRangoA(unidadAAtacar, rango)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        try{
            unidadAAtacar.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            throw new EstaDestruido("Unidad Destruida");
        }
    }

    public Integer[] obtenerPosicion() {
        Integer[] posicion = new Integer[2];
        posicion[0] = casillero.posicionX();
        posicion[1] = casillero.posicionY();
        return posicion;
    }

    public int getVida() {
        return vida.getVida();
    }
    public int getVidaMaxima() {
        return vida.getVidaMaxima();
    }
}
