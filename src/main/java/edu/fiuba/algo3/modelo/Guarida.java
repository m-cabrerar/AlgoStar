package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.EdificioOcupado;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Guarida extends EdificioZerg {

    private static int VIDA_MAXIMA = 1250;
    public Guarida(Casillero casillero, Inventario inventario){
    super(casillero, inventario, VIDA_MAXIMA);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 12;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.esDelTipo(new Moho())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(200, 100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneReservaDeReproduccion()){
            throw new UbicacionInvalida("Aun no se puede construir este edificio");
        }
        EdificioConcreto guarida = new Guarida(casillero, inventario);
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
