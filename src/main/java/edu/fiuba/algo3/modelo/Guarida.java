package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

public class Guarida extends EdificioZerg {

    private static int VIDA_MAXIMA = 1250;
    public Guarida(Casillero casillero, Inventario inventario){
    super(casillero, inventario, VIDA_MAXIMA);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(2);
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

    public void recibirDanio(Danio danio){
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.casillero.desocupar();
        }
    }

}
