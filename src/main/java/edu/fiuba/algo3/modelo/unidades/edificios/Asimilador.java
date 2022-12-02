package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class Asimilador extends EdificioProtoss {

    public Asimilador(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 450, 450);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(0);
    }

    public int turnosParaConstruir(){
        return 6;
    }

    public void pasarTurno(){
        super.pasarTurno();
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        Asimilador asimilador = new Asimilador(casillero, inventario);
        if(!inventario.tieneRecursos(0, 100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        return new EdificioEnConstruccion(asimilador, casillero, inventario);
    }

    public int extraerGas() { //TODO: hacer privado y que se llame desde pasarTurno
        return casillero.extraerGas(20);
    }

}
