package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

import java.util.List;

public class EdificioEnConstruccion implements Unidad {
    private Unidad vaASer;
    private Casillero casillero;
    private int turnosRestantes;
    private boolean destruido;

    public EdificioEnConstruccion(EdificioConcreto vaASer, Casillero casillero, Inventario inventario) {
        this.vaASer = vaASer;
        this.casillero = casillero;
        this.turnosRestantes = vaASer.turnosParaConstruir();
        casillero.ocupar();
        this.destruido = false;
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

    public void recibirDanio(int danio) throws EstaDestruido {
        if (destruido){
            throw new EstaDestruido("El edificio está destruido");
        }
        if (!estaListo()) {
            casillero.desocupar();
            destruido = true;
        } else {
            vaASer.recibirDanio(danio);
        }
    }

    public boolean estaPorAca(List<Casillero> casilleros){
        return casilleros.contains(casillero);
    }

}
