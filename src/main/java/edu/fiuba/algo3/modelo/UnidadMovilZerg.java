package edu.fiuba.algo3.modelo;

public abstract class UnidadMovilZerg extends UnidadMovil{
    int vidaMaxima;

    UnidadMovilZerg(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas, costoSuministro);
        this.vida = vidaInicial;
        this.vidaMaxima = vidaInicial;
    }
    @Override
    public void pasarTurno() {
        if (this.vida < (vidaMaxima-10)){
            this.vida+=10;
        }
        else if(vida < vidaMaxima){
            this.vida = vidaMaxima;
        }
    }

}
