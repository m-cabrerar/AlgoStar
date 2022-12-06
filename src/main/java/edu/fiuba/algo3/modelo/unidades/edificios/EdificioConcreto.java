package edu.fiuba.algo3.modelo.unidades.edificios;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

import java.util.List;

abstract class EdificioConcreto implements Unidad, Construible {
    
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
        try {
            vida.sufrirAtaque(superficie.danio(danio));
        } catch (Exception EstaDestruido){
            casillero.desocupar();
            throw new EstaDestruido("Unidad destruida");
        }
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

    public int[] obtenerPosicion(){
        int[] posicion = new int[2];
        posicion[0] = casillero.posicionX();
        posicion[1] = casillero.posicionY();
        return posicion;
    }

}
