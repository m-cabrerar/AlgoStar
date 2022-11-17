package edu.fiuba.algo3.modelo;

public class Casillero{
    private TipoCasillero tipoCasillero;
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
        return tipoCasillero.nombreDelCasillero();
    }

    //revisar esto, sino rompia encapsulamiento
    public void extraerMineral(Inventario inventario, int cantidad) throws Exception {
        this.tipoCasillero.extraerMineral(inventario, cantidad);
    }
/*
    public boolean puedeConstruir(EdificioConcreto edificioConcreto) {
    }

 */
}
