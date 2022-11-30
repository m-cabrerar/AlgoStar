package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Espiral extends EdificioZerg {

    private static int VIDA_MAXIMA = 1300;
    public Espiral(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA_MAXIMA);
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
        return 10;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(150,100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneGuarida()){
            throw new UbicacionInvalida("Aun no se puede construir este edificio");
        }
        Espiral espiral = new Espiral(casillero, inventario);
        casillero.ocupar(espiral);
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
