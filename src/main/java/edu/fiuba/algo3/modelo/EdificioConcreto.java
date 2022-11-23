package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

import java.util.List;

abstract class EdificioConcreto implements Unidad {
    protected int vida;
    protected Casillero casillero;
    protected UnidadMovil unidadEnConstruccion = null;
    protected int turnosParaConstruir = 0;
    protected Inventario inventario;
    public EdificioConcreto(Casillero unCasillero, Inventario unInventario, int vidaInicial) throws UbicacionInvalida {
        this.casillero = unCasillero;
        unCasillero.ocupar();
        unInventario.agregar(this);
        this.vida = vidaInicial;
        this.inventario = unInventario;
    }
    public void pasarTurno(){
        if (unidadEnConstruccion()) {
            turnosParaConstruir--;
        }
    }
    abstract int turnosParaConstruir();
    protected boolean estaDestruido() {
        return vida <= 0;
    }
    public void recibirDanio(int danio) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        vida -= danio;
        if (estaDestruido()){
            casillero.desocupar();
        }
    }
    private void consumirMateriales(Inventario inventario) {
    }
    private boolean tieneCorrelativas(Inventario inventario) {
        return true;
    }
    private boolean tieneMateriales(Inventario inventario) {
        return true;
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
