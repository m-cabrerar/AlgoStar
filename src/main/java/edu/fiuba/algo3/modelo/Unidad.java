package edu.fiuba.algo3.modelo;

import java.util.List;
import edu.fiuba.algo3.exceptions.*;

public interface Unidad {
    void pasarTurno();
    void recibirDanio(int danio) throws EstaDestruido;
    boolean estaPorAca(List<Casillero> casilleros);

}
