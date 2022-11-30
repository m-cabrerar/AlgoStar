package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

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
        Asimilador asimilador = new Asimilador(casillero, inventario);
        if(!inventario.tieneRecursos(0, 100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        casillero.ocupar(asimilador);
        return new EdificioEnConstruccion(asimilador, casillero, inventario);
    }

    public int extraerGas() { //TODO: hacer privado y que se llame desde pasarTurno
        return casillero.extraerGas(20);
    }

    @Override
    public void ocupar(Casillero casillero) throws UbicacionInvalida {
        casillero.ocupar(this);
    }
}
