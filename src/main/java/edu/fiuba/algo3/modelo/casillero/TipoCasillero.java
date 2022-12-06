package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.Asimilador;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

import java.util.List;

public abstract class TipoCasillero{

    public int extraerMineral(int cantidad){
        return 0;
    }

    public int extraerGas(int cantidad){
        return 0;
    }
    public void expandirMoho(List<Casillero> casillasAContagiar){}

    //METODOS PARA DOUBLE DISPATCH ---------------------------------------------------------------
    public boolean ocupar(UnidadMovil unidad){
        return true;
    }
    public boolean ocupar(Extractor extractor){throw new UbicacionInvalida("Ubicacion invalida");}
    public boolean ocupar(Asimilador asimilador){throw new UbicacionInvalida("Ubicacion invalida");}
    public boolean ocupar(NexoMineral nexo){
        throw new UbicacionInvalida("Ubicacion invalida");
    }
    public boolean ocupar(Criadero criadero){
        throw new UbicacionInvalida("Ubicacion invalida");
    }
    public boolean ocupar (Unidad unidad) throws UbicacionInvalida { throw new UbicacionInvalida("Ubicacion invalida");
    }
}
