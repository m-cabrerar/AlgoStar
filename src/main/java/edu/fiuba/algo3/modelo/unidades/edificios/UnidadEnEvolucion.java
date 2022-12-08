package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovilZerg;

public class UnidadEnEvolucion extends EdificioZerg{
    private final int turnosParaEvolucionar;
    private int turnosTranscurridos;
    private final UnidadMovilZerg unidad;
    private EdificioEnConstruccion edificio;

    public UnidadEnEvolucion(Casillero casillero, Inventario inventario, UnidadMovilZerg unidad){
        super(casillero, inventario, 1);
        this.turnosParaEvolucionar = unidad.turnosParaConstruir();
        this.turnosTranscurridos = 0;
        this.unidad = unidad;
        casillero.ocupar(this);
        edificio = new EdificioEnConstruccion(this, casillero, inventario);
    }

    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(0);
    }

    public void pasarTurno(){
        super.pasarTurno();
        turnosTranscurridos++;
        if (turnosTranscurridos == turnosParaEvolucionar){
            inventario.edificioAEliminar(edificio);
            casillero.desocupar();
            unidad.ubicarEn(casillero);
            inventario.agregarUnidad(unidad);
        }
    }
    @Override
    public int turnosParaConstruir() {
        return 0;
    }
}