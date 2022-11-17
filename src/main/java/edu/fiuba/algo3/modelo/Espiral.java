package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EdificioOcupado;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Espiral extends EdificioZerg {

    private static int VIDA_MAXIMA = 1300;
    public Espiral(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA_MAXIMA);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 10;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.esDelTipo(new Moho())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(150,100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneGuarida()){
            throw new UbicacionInvalida("Aun no se puede construir este edificio");
        }
        EdificioConcreto espiral = new Espiral(casillero, inventario);
        return new EdificioEnConstruccion(espiral, casillero, inventario);
    }
    public UnidadMovil crearEvolucion(Inventario inventario) throws RecursosInsuficientes {
        return new Mutalisco(inventario);
    }

    public void engendrarMutalisco(UnidadMovil unidad, Inventario inventario) throws RecursosInsuficientes, EdificioOcupado {
        if (unidadEnConstruccion()) {
            throw new EdificioOcupado("El edificio está ocupado");
        }
        unidadEnConstruccion = crearEvolucion(inventario);
        turnosParaConstruir = unidadEnConstruccion.turnosParaConstruir();
    }

}
