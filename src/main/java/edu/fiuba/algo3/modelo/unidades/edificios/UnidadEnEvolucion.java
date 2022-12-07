package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class UnidadEnEvolucion {

    private Casillero casilleroDondeSeUbicara;
    private Inventario inventario;
    private int turnosParaEvolucionar;
    private final UnidadMovil unidad;

    public UnidadEnEvolucion(Casillero casilleroDondeSeUbicara, Inventario inventario, UnidadMovil unidad){
        this.inventario = inventario;
        this.turnosParaEvolucionar = unidad.turnosParaConstruir();
        this.casilleroDondeSeUbicara = casilleroDondeSeUbicara;
        this.unidad = unidad;
    }

    public void pasarTurno(){
        turnosParaEvolucionar--;
        if (turnosParaEvolucionar <= 0){
            inventario.agregarUnidad(unidad);
            unidad.ubicarEn(casilleroDondeSeUbicara);
        }
    }

    public boolean estaListo(){
        return turnosParaEvolucionar <= 0;
    }

}
