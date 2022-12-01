package edu.fiuba.algo3.modelo;


public abstract class UnidadMovilProtoss extends UnidadMovil {

    UnidadMovilProtoss(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int escudoInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas,costoSuministro);
        this.vida = new VidaProtoss(vidaInicial, escudoInicial);
    }

    public void pasarTurno() {
        vida.pasarTurno();
    }
}
