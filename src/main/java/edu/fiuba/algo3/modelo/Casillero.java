package edu.fiuba.algo3.modelo;

public class Casillero implements EdificioZerg{
    private TipoCasillero unTipoCasillero;
    private int energia;
    private int coordenadaX;
    private int coordenadaY;
    public void setTipoCasillero(TipoCasillero unTipoCasillero){
        tipoCasillero = unTipoCasillero;
    }

    public boolean sonDelMismoTipoDeCasillero(Casillero unCasillero){
        return (this.suTipoDeCasillero() == unCasillero.suTipoDeCasillero());
    }
    public String suTipoDeCasillero(){
        return unTipoCasillero.nombreDelCasillero();
    }

}
