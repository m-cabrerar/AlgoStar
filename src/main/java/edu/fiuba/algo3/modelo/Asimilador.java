package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.CorrelativasInsuficientes;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Asimilador extends EdificioProtoss {
    public Asimilador(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 450, 450);
    }

    public int turnosParaConstruir(){
        return 6;
    }

    public void pasarTurno(){
        super.pasarTurno();
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        EdificioConcreto asimilador = new Asimilador(casillero, inventario);
        if(!casillero.esDelTipo(new NodoGas())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(0, 100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        return new EdificioEnConstruccion(asimilador, casillero, inventario);
    }

    public int extraerGas() { //TODO: hacer privado y que se llame desde pasarTurno
        casillero.extraerGas(20);
        return 20;
    }
}
