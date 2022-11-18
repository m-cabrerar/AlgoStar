package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public interface Unidad {
    public void pasarTurno() throws Exception;
    public void recibirDanio(int danio) throws EstaDestruido;

}
