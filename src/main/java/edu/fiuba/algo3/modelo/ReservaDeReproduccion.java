package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

public class ReservaDeReproduccion extends EdificioZerg {

    private static int VIDA_MAXIMA = 1000;
    public ReservaDeReproduccion(Casillero casillero, Inventario inventario){
        super(casillero, inventario,VIDA_MAXIMA);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(1);
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
        if(!inventario.tieneRecursos(150,0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(casillero, inventario);
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

    public void recibirDanio(Danio danio){
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.casillero.desocupar();
        }
    }

}

