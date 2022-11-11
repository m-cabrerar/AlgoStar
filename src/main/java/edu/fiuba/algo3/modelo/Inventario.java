package edu.fiuba.algo3.modelo;

public class Inventario {
    int cantidadGas;
    int cantidadMineral;

    public Inventario Inventario(int cantidadInicialGas, int cantidadInicialMineral ){
        this.cantidadGas = cantidadInicialGas;
        this.cantidadMineral = cantidadInicialMineral;
    }

    private boolean puedePagar(int pagoDeMineral, int pagoDeGas){
        if(this.cantidadDeMineral < pagoDeMineral or this.cantidadGas < pagoDeGas){
            return false;
        }
        return true;
    }
    public void pagar(int pagoDeGas, int pagoDeMineral){
        if (!this.puedePagar(pagoDeGas, pagoDeMineral)) { //ACA DE UNA USAR PAGAR Y ESO CUBRE ESTA EXEPCION
            throw new Exception("Materiales insuficientes");
        }
        this.cantidadGas -= pagoDeGas;
        this.cantidadMineral -= pagoDeMineral;
    }
}
