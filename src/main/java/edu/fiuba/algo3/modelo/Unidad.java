package edu.fiuba.algo3.modelo;

import java.util.List;
import edu.fiuba.algo3.exceptions.*;

public interface Unidad {
    public void pasarTurno();
    public void recibirDanio(int danio) throws EstaDestruido;
    public boolean estaPorAca(List<Casillero> casilleros);

}
