package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public class UnidadEnConstruccion implements Unidad{
    private Unidad vaASer;
    private Casillero casillero;
    private int turnosRestantes;

    public UnidadEnConstruccion(UnidadConcreta vaASer, Casillero casillero, Inventario inventario) {
        this.vaASer = vaASer;
        this.casillero = casillero;
        this.turnosRestantes = vaASer.turnosParaConstruir();
        casillero.ocupar();
    }
    private boolean estaListo() {
        return turnosRestantes <= 0;
    }
    public void pasarTurno() {
        if (estaListo()) {
            vaASer.pasarTurno();
        } else {
            turnosRestantes--;
        }
    }
    public void recibirDanio(int danioTierra, int danioAire){
        casillero.desocupar();
    }

    public boolean puedeVolar() {
        return false;
    }
}
