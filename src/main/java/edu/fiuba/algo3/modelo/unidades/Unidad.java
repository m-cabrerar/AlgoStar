package edu.fiuba.algo3.modelo.unidades;

import java.util.List;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;

public interface Unidad {
    void pasarTurno();
    void recibirDanio(Danio danio) throws EstaDestruido;
    boolean estaPorAca(List<Casillero> casilleros);
    public int[] obtenerPosicion();
    
}
