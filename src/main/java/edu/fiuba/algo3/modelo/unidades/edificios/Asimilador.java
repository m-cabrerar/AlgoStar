package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class Asimilador extends EdificioProtoss {
<<<<<<< Updated upstream
=======
    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 100;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
>>>>>>> Stashed changes

    public Asimilador(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 450, 450);
        casillero.ocupar(this);
<<<<<<< Updated upstream
        inventario.subirNivelConstruccion(0);
=======
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);

>>>>>>> Stashed changes
    }

    public int turnosParaConstruir(){
        return 6;
    }

    public void pasarTurno(){
        super.pasarTurno();
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
<<<<<<< Updated upstream
        Asimilador asimilador = new Asimilador(casillero, inventario);
        if(!inventario.tieneRecursos(0, 100)){
=======
        if (!inventario.tieneRecursos(0, 100)) {
>>>>>>> Stashed changes
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Asimilador asimilador = new Asimilador(casillero, inventario);
        return new EdificioEnConstruccion(asimilador, casillero, inventario);
    }

    public int extraerGas() { //TODO: hacer privado y que se llame desde pasarTurno
        return casillero.extraerGas(20);
    }

}
