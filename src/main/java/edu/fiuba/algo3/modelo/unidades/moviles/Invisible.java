package edu.fiuba.algo3.modelo.unidades.moviles;


import edu.fiuba.algo3.modelo.unidades.Danio;

public class Invisible implements Visibilidad{

    @Override
    public Danio danioARecibir(Danio danioA) {
        return (new Danio(0, 0));
    }

    public boolean esVisible(){
        return false;
    }
}

