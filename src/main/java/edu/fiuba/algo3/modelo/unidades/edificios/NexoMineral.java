package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class NexoMineral extends EdificioProtoss {

<<<<<<< Updated upstream
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 250, 250);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(0);
=======
    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 50;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    public NexoMineral(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 250, 250);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
>>>>>>> Stashed changes
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public int turnosParaConstruir() {
        return 4;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
<<<<<<< Updated upstream

=======
        NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        System.out.println("Nexo Mineral creado");
>>>>>>> Stashed changes
        return new EdificioEnConstruccion(nexoMineral, casillero, inventario);
    }

    public int extraerMineral(Inventario inventario) { // TODO: hacer privado y que se llame desde pasarTurno
        int cantidad = casillero.extraerMineral(20);
        inventario.agregarMineral(cantidad);
        return cantidad;
    }


}
