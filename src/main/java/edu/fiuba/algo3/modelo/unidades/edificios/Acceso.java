package edu.fiuba.algo3.modelo.unidades.edificios;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class Acceso extends EdificioProtoss {

    public Acceso(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 500, 500);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(1);
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
        return 8;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario){
        Acceso acceso = new Acceso(casillero, inventario);
        if(!casillero.tieneEnergia()){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(0, 150)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        return new EdificioEnConstruccion(acceso, casillero, inventario);
    }
}
