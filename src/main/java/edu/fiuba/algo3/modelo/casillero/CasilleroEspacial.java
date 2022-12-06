package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class CasilleroEspacial extends TipoCasillero {
    @Override
    public boolean ocupar(UnidadMovil unidad) throws UbicacionInvalida {
        if (unidad.esVoladora()){return true;}
        throw new UbicacionInvalida("Ubicacion invalida");
    }

}
