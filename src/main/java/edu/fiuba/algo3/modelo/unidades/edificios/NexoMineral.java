package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class NexoMineral extends EdificioProtoss {

    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 250, 250);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(0);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public int turnosParaConstruir() {
        return 4;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        if(!inventario.tieneRecursos(0, 50)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }

        return new EdificioEnConstruccion(nexoMineral, casillero, inventario);
    }

    public int extraerMineral(Inventario inventario) { // TODO: hacer privado y que se llame desde pasarTurno
        int cantidad = casillero.extraerMineral(20);
        inventario.agregarMineral(cantidad);
        return cantidad;
    }


}
