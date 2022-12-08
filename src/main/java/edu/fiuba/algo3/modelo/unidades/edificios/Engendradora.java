package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class Engendradora {

    private Casillero casillero;
    private Inventario inventario;
    private int turnosParaEvolucionar;
    private final UnidadMovil unidad;

    public Engendradora(Casillero casillero, Inventario inventario, UnidadMovil unidad){
        this.inventario = inventario;
        this.turnosParaEvolucionar = unidad.turnosParaConstruir();
        this.casillero = casillero;
        this.unidad = unidad;
    }

    public void pasarTurno(){
        turnosParaEvolucionar--;
        if (turnosParaEvolucionar <= 0){
            inventario.agregarUnidad(unidad);
            unidad.ubicarEn(casillero.obtenerAdyacente());
        }
    }

    public boolean estaListo(){
        return turnosParaEvolucionar <= 0;
    }
}
