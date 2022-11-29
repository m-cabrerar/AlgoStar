package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class NexoMineral extends EdificioProtoss {
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 250, 250);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public int turnosParaConstruir() {
        return 4;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        EdificioConcreto nexoMineral = new NexoMineral(casillero, inventario);
        if(!casillero.esDelTipo(new NodoMineral())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(0, 50)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        return new EdificioEnConstruccion(nexoMineral, casillero, inventario);
    }

    public int extraerMineral() { // TODO: hacer privado y que se llame desde pasarTurno
        return casillero.extraerMineral(20);
    }
}
