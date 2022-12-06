package edu.fiuba.algo3.modelo.unidades.edificios;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class Guarida extends EdificioZerg {

<<<<<<< Updated upstream
=======
    private static int COSTO_GASEOSO = 200;
    private static int COSTO_MINERAL = 100;
    private static final int NIVEL_DE_CONSTRUCCION = 2;
>>>>>>> Stashed changes
    private static int VIDA_MAXIMA = 1250;
    public Guarida(Casillero casillero, Inventario inventario){
    super(casillero, inventario, VIDA_MAXIMA);
        casillero.ocupar(this);
<<<<<<< Updated upstream
        inventario.subirNivelConstruccion(2);
=======
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
>>>>>>> Stashed changes
    }
    public void pasarTurno(){
        super.pasarTurno();
        UnidadMovil unidad = obtenerUnidad();
        if(unidad!=null){
            unidad.ubicarEn(casillero.obtenerAdyacente());
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }
    public int turnosParaConstruir(){
        return 12;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(200, 100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(1)){
            throw new CorrelativasInsuficientes("Aún no se puede construir este edificio");
        }
        Guarida guarida = new Guarida(casillero, inventario);
        return new EdificioEnConstruccion(guarida, casillero, inventario);
    }
    public UnidadMovil crearEvolucion(Inventario inventario) throws RecursosInsuficientes {
        return new Hidralisco(inventario);
    }
    public void engendrarHidralisco(UnidadMovil unidad, Inventario inventario) throws RecursosInsuficientes, EdificioOcupado {
        if (unidadEnConstruccion()) {
            throw new EdificioOcupado("El edificio está ocupado");
        }
        unidadEnConstruccion = crearEvolucion(inventario);
        turnosParaConstruir = unidadEnConstruccion.turnosParaConstruir();
    }

}
