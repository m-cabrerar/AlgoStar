package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

public class Acceso extends EdificioProtoss {
    public Acceso(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, 500, 500);
    }

    public void pasarTurno() {
        super.pasarTurno();
        if(obtenerUnidad()!=null){
            UnidadMovil unidad = obtenerUnidad();
            unidad.ubicarEn(casillero.obtenerAdyacente());
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }

    public void recibirDanio(Danio danio){
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.casillero.desocupar();
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
        casillero.ocupar(acceso);
        return new EdificioEnConstruccion(acceso, casillero, inventario);
    }
}
