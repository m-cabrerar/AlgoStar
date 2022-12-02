package edu.fiuba.algo3.modelo.unidades;

public class Tierra implements Superficie {
    
    public int danio(Danio danio) {
        return danio.ataqueTerrestre();
    }
    public boolean puedeVolar(){return false;}
}
