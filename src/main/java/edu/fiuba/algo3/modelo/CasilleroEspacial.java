package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.CasilleroNoCompatible;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class CasilleroEspacial extends TipoCasillero {
    @Override
    public boolean ocupar(UnidadMovil unidad) throws UbicacionInvalida {
        if (unidad.esVoladora()){return true;}
        throw new CasilleroNoCompatible("Ubicacion invalida");
    }

}
