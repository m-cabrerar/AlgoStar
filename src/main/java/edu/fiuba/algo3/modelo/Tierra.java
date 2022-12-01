package edu.fiuba.algo3.modelo;

public class Tierra implements Superficie {
    
    public int danio(Danio danio) {
        return danio.ataqueTerrestre();
    }
    public boolean puedeVolar(){return false;}
}
