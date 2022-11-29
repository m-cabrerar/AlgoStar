package edu.fiuba.algo3.modelo;

public class UnidadEnEvolucion extends EdificioZerg{
    private final int turnosParaEvolucionar;
    private int turnosTranscurridos;
    private final UnidadMovilZerg unidad;

    public UnidadEnEvolucion(Casillero casillero, Inventario inventario, UnidadMovilZerg unidad){
        super(casillero, inventario, 1);
        this.turnosParaEvolucionar = unidad.turnosParaConstruir();
        this.turnosTranscurridos = 0;
        this.unidad = unidad;
    }

    public void pasarTurno(){
        super.pasarTurno();
        turnosTranscurridos++;
        if (turnosTranscurridos == turnosParaConstruir){
            casillero.desocupar();
            inventario.agregar(unidad);
            unidad.ubicarEn(casillero);
        }
    }
    @Override
    public int turnosParaConstruir() {
        return 0;
    }
}
