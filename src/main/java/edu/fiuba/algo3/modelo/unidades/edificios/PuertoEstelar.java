package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.Dragon;
import edu.fiuba.algo3.modelo.unidades.moviles.Scout;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class PuertoEstelar extends EdificioProtoss {
    private static int COSTO_GASEOSO = 150;
    private static int COSTO_MINERAL = 150;
    private static int VIDA = 600;
    private static int ESCUDO = 600;
    private static int TURNOS_PARA_CONSTRUIR = 10;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    private boolean estaEvolucionando;
    private UnidadEnEvolucion unidadEnEvolucion;
    public PuertoEstelar(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA, ESCUDO);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        this.estaEvolucionando = false;
        this.unidadEnEvolucion = null;
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }

    public void pasarTurno() {
        super.pasarTurno();
        if(estaEvolucionando){
            unidadEnEvolucion.pasarTurno();
            this.estaEvolucionando = unidadEnEvolucion.estaListo();
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }

    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if(!casillero.tieneEnergia()){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(1)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        return new EdificioEnConstruccion(puertoEstelar, casillero, inventario);
    }

    public static int getNivelDeConstruccion(){
        return NIVEL_DE_CONSTRUCCION;
    }

    public void engendrarScout(){
        Scout scout = new Scout(inventario);
        this.unidadEnEvolucion = new UnidadEnEvolucion(this.casillero, this.inventario, scout);
        this.estaEvolucionando = true;
    }
}
