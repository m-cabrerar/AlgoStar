package edu.fiuba.algo3.modelo.unidades;

public class Danio {

    private int danioAereo;
    private int danioTerrestre;

    public Danio(int danioAereo, int danioTerrestre){
        this.danioAereo = danioAereo;
        this.danioTerrestre = danioTerrestre;
    }

    public int ataqueAereo() {
        return danioAereo;
    }

    public int ataqueTerrestre(){
        return danioTerrestre;
    }


}
