package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public interface Unidad {
    public void pasarTurno();
    public void recibirDanio(int danio) throws EstaDestruido;
}
