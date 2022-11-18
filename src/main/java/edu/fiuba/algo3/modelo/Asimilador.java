package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Asimilador extends EdificioProtoss {
    public Asimilador(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 450, 450);
    }

    public int turnosParaConstruir(){
        return 6;
    }

    protected Inventario inventario;
    public void pasarTurno() throws Exception {
        //super.pasarTurno();
        this.inventario.agregarGas(this.extraerGas());
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
        return casillero.extraerGas(20);
    }
}
