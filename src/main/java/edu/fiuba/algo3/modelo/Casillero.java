package edu.fiuba.algo3.modelo;

public class Casillero {

    private TipoCasillero unTipoCasillero;
    private int energia;
    private int coordenadaX;
    private int coordenadaY;
    public void setTipoCasillero(TipoCasillero unTipoCasillero){
        tipoCasillero = unTipoCasillero;
    }

    public boolean puedeConstruir(Edificio unEdificio){
        //Sudoku: similar a ver si se puede poner un numero.
        return (this.unTipoCasillero).esCompatible(unEdificio);
    }
}
