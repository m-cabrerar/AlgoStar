package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class NexoMineral extends EdificioProtoss {
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 250, 250);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    int turnosParaConstruir() {
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

    public int extraerMineral(int cantidadMineral) { // TODO: hacer privado y que se llame desde pasarTurno
        return cantidadMineral + casillero.extraerMineral(20);
    }
} //    QUE RECIBA LA CANTIDAD QUE TIENE EL INVENTARIO, LE SUME 20 Y LA DEVUELVE
