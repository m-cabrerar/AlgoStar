package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

public class Zerling extends UnidadMovil {
    Zerling(Inventario inventario){
        if(!inventario.tieneRecursos(25,0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
    }
    @Override
    int turnosParaConstruir() {
        return 2;
    }
}
