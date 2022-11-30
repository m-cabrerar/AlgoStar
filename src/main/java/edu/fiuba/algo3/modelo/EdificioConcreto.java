package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

import java.util.List;

abstract class EdificioConcreto implements Unidad, Construible{
    protected int vida;
    protected Casillero casillero;
    protected UnidadMovil unidadEnConstruccion = null;
    protected int turnosParaConstruir = 0;
    protected Inventario inventario;
    public EdificioConcreto(Casillero unCasillero, Inventario unInventario, int vidaInicial) throws UbicacionInvalida {
        this.casillero = unCasillero;
        unInventario.agregar(this);
        this.vida = vidaInicial;
        this.inventario = unInventario;
    }
    public void pasarTurno(){
        if (unidadEnConstruccion()) {
            turnosParaConstruir--;
        }
    }
    protected boolean estaDestruido() {
        return this.vida <= 0;
    }
    public void recibirDanio(int danio) throws EstaDestruido {
        if (this.estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        this.vida -= danio;
        if (this.estaDestruido()){
            this.casillero.desocupar();
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

}
