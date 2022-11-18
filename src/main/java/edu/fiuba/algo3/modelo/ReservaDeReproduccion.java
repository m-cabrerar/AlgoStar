package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

public class ReservaDeReproduccion extends EdificioZerg {

    private static int VIDA_MAXIMA = 1000;
    public ReservaDeReproduccion(Casillero casillero, Inventario inventario){
        super(casillero, inventario,VIDA_MAXIMA);
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
        if(!inventario.tieneRecursos(150,0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        EdificioConcreto reserva = new ReservaDeReproduccion(casillero, inventario);
        return new EdificioEnConstruccion(reserva, casillero, inventario);
    }
    public UnidadMovil crearEvolucion(Inventario inventario) throws RecursosInsuficientes {
        return new Zerling(inventario);
    }

    public void engendrarZerling(UnidadMovil unidad, Inventario inventario) throws RecursosInsuficientes, EdificioOcupado {
        if (unidadEnConstruccion()) {
            throw new EdificioOcupado("El edificio está ocupado");
        }
        unidadEnConstruccion = crearEvolucion(inventario);
        turnosParaConstruir = unidadEnConstruccion.turnosParaConstruir();
    }
}