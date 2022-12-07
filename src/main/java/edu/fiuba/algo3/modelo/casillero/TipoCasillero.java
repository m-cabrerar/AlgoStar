package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import edu.fiuba.algo3.modelo.unidades.moviles.Guardian;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

import java.util.List;

public class TipoCasillero{

    public int extraerMineral(int cantidad){
        return 0;
    }

    public int extraerGas(int cantidad){
        return 0;
    }
    public void expandirMoho(List<Casillero> casillasAContagiar){}

    public void volverseMoho(Casillero casillero){return;}

    //METODOS PARA DOUBLE DISPATCH ---------------------------------------------------------------
    public void ocupar(UnidadMovil unidad){}
    public void ocupar(Extractor extractor){throw new UbicacionInvalida("Ubicacion invalida");}
    public void ocupar(Asimilador asimilador){throw new UbicacionInvalida("Ubicacion invalida");}
    public void ocupar(NexoMineral nexo){
        throw new UbicacionInvalida("Ubicacion invalida");
    }
    public void ocupar(Criadero criadero){
        throw new UbicacionInvalida("Ubicacion invalida");
    }
    public void ocupar (Unidad unidad) throws UbicacionInvalida { throw new UbicacionInvalida("Ubicacion invalida");
    }
    public void ocupar (ReservaDeReproduccion reservaDeReproduccion) throws UbicacionInvalida { throw new UbicacionInvalida("Ubicacion invalida");
    }
    public void ocupar (Guarida guarida) throws UbicacionInvalida { throw new UbicacionInvalida("Ubicacion invalida");
    }
    public void ocupar (Espiral espiral) throws UbicacionInvalida { throw new UbicacionInvalida("Ubicacion invalida");
    }
}
