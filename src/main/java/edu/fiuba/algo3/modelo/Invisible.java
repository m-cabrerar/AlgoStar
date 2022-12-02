package edu.fiuba.algo3.modelo;


public class Invisible implements Visibilidad{

    @Override
    public Danio danioARecibir(Danio danioA) {
        return(new Danio(0,0));
    }
