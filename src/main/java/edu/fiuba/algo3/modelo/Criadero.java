package edu.fiuba.algo3.modelo;

public class Criadero extends EdificioConcreto{
    //PROVISORIO TDD
    private int cantidadLarvas;
    private int cantidadZanganos;

    public Criadero(Casillero casillero, Inventario inventario) {
        super();
        cantidadLarvas = 3;
        cantidadZanganos = 0;
    }

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
        if(estaEnCapacidadMaxima()){
            return;
        }
        this.cantidadLarvas += 1;
    }

}
