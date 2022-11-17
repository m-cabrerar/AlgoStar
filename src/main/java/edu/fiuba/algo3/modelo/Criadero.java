/*
package edu.fiuba.algo3.modelo;

public class Criadero extends EdificioZerg{
    //PROVISORIO TDD
    private int cantidadLarvas;
    private int cantidadZanganos;

    public void engendrarZangano(){
        if(!this.tieneLarvas()){
            throw new Exception("Ya no quedan larvas disponibles");
        }
        this.cantidadLarvas -= 1;
        this.cantidadZanganos += 1;
    }

    private boolean tieneLarvas(){
        return cantidadLarvas > 0;
    }
    private boolean estaEnCapacidadMaxima(){
        return cantidadLarvas == 3;
    }

    public void pasarTurno(){
        //recuperar vida
        if(estaEnCapacidadMaxima()){
            return;
        }
        this.cantidadLarvas += 1;

    }

}

 */