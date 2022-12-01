package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class PuertoEstelar extends EdificioProtoss {
    public PuertoEstelar(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 600, 600);
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
        return 10;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        if(!casillero.tieneEnergia()){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(150, 150)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneAcceso()){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        casillero.ocupar(puertoEstelar);
        return new EdificioEnConstruccion(puertoEstelar, casillero, inventario);
    }

    public void recibirDanio(Danio danio){
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.casillero.desocupar();
        }
    }

}
