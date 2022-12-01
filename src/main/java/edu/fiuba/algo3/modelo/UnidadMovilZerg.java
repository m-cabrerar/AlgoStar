package edu.fiuba.algo3.modelo;

public abstract class UnidadMovilZerg extends UnidadMovil{

    UnidadMovilZerg(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas, costoSuministro);
        this.vida = new VidaZerg(vidaInicial);
    }
    public void pasarTurno() {
        vida.pasarTurno();
    }

    

}
