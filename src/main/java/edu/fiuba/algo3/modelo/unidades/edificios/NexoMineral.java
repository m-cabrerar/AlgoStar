package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class NexoMineral extends EdificioProtoss {

    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 50;
    private static int VIDA = 250;
    private static int ESCUDO = 250;
    private static int TURNOS_PARA_CONSTRUIR = 4;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA, ESCUDO);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }

    public void pasarTurno() {
        super.pasarTurno();
        extraerMineral();
    }

    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        System.out.println("Nexo Mineral creado");
        return new EdificioEnConstruccion(nexoMineral, casillero, inventario);
    }

    public int extraerMineral() { // TODO: hacer privado y que se llame desde pasarTurno
        int cantidad = casillero.extraerMineral(20);
        this.inventario.agregarMineral(cantidad);
        return cantidad;
    }
    public static int getNivelDeConstruccion(){
        return NIVEL_DE_CONSTRUCCION;
    }

}
