package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import java.util.List;

public interface Unidad {
    public void pasarTurno();
    public void recibirDanio(int danio) throws EstaDestruido;
    public boolean estaPorAca(List<Casillero> casilleros);

}
