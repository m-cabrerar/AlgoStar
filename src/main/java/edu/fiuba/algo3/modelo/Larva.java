package edu.fiuba.algo3.modelo;

public class Larva extends UnidadMovil {
    public int turnosParaConstruir(){
        return 0;
    }

    public UnidadMovil evolucionar(EdificioConcreto edificio, Inventario inventario){
        return edificio.crearEvolucion(inventario);
    }
}
