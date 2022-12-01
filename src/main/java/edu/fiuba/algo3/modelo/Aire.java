package edu.fiuba.algo3.modelo;

public class Aire implements Superficie {
    
    public int danio(Danio danio) {
        return danio.ataqueAereo();
    }

    public boolean puedeVolar(){return true;}
}
