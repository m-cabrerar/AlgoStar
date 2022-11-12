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
        if (!this.puedePagar(pagoDeGas, pagoDeMineral)) {
            throw new Exception("Materiales insuficientes");
        }
        this.cantidadGas -= pagoDeGas;
        this.cantidadMineral -= pagoDeMineral;
    }

    public void recibirMineral(int cantidad){
        this.cantidadMineral += cantidad;
    }
    public void recibirGas(int cantidad){
        this.cantidadGas += cantidad;
    }
}
