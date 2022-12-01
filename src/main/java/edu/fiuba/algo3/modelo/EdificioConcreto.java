package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

import java.util.List;

abstract class EdificioConcreto implements Unidad, Construible{
    
    protected Superficie superficie;
    protected Vida vida;
    protected Casillero casillero;
    protected UnidadMovil unidadEnConstruccion = null;
    protected int turnosParaConstruir = 0;
    protected Inventario inventario;
    
    public EdificioConcreto(Casillero unCasillero, Inventario unInventario) throws UbicacionInvalida {
        this.casillero = unCasillero;
        unInventario.agregar(this);
        this.inventario = unInventario;
        superficie = new Tierra();
    }
    
    public void pasarTurno(){
        if (unidadEnConstruccion()) {
            turnosParaConstruir--;
        }
    }
    
    public void recibirDanio(Danio danio) throws EstaDestruido{
        vida.sufrirAtaque(superficie.danio(danio));
    }
    // TODO: evitar null
    protected boolean unidadEnConstruccion() {
        return unidadEnConstruccion != null;
    }
    protected boolean unidadEstaLista() {
        return turnosParaConstruir <= 0;
    }
    public UnidadMovil obtenerUnidad() {
        if (!unidadEstaLista()) {
            return null;
        }
        UnidadMovil unidad = unidadEnConstruccion;
        unidadEnConstruccion = null;
        return unidad;
    }

    public boolean estaPorAca(List<Casillero> casilleros){
        return casilleros.contains(casillero);
    }

    public UnidadMovil crearEvolucion(Inventario inventario) {
        return null;
    }

}
