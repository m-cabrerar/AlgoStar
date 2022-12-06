package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class PuertoEstelar extends EdificioProtoss {
    private static int COSTO_GASEOSO = 150;
    private static int COSTO_MINERAL = 150;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    public PuertoEstelar(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 600, 600);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }

    public void pasarTurno() {
        super.pasarTurno();
        if(obtenerUnidad()!=null){
            UnidadMovil unidad = obtenerUnidad();
            unidad.ubicarEn(casillero.obtenerAdyacente());
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }

    public int turnosParaConstruir() {
        return 10;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if(!casillero.tieneEnergia()){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(150, 150)){
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
}
