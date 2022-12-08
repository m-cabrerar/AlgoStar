package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class Espiral extends EdificioZerg {

    private static int COSTO_GASEOSO = 100;
    private static int COSTO_MINERAL = 150;
    private static final int NIVEL_DE_CONSTRUCCION = 3;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 2;
    private static int TURNOS_PARA_CONSTRUIR = 10;
    private static int VIDA_MAXIMA = 1300;
    public Espiral(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA_MAXIMA);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }
    public void pasarTurno(){
        super.pasarTurno();
        UnidadMovil unidad = obtenerUnidad();
        if(unidad != null){
            unidad.ubicarEn(casillero.obtenerAdyacente());
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(COSTO_GASEOSO,COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(NIVEL_DE_CONSTRUCCION_REQUERIDO)){
            throw new CorrelativasInsuficientes("Aún no se puede construir este edificio");
        }
        Espiral espiral = new Espiral(casillero, inventario);
        return new EdificioEnConstruccion(espiral, casillero, inventario);
    }
    public UnidadMovil crearEvolucion(Inventario inventario) throws RecursosInsuficientes {
        return new Mutalisco(inventario);
    }

    public static int getNivelDeConstruccionRequerido() {
        return NIVEL_DE_CONSTRUCCION_REQUERIDO;
    }
}
