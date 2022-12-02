package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.VidaZerg;

public abstract class UnidadMovilZerg extends UnidadMovil{

    UnidadMovilZerg(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas, costoSuministro);
        this.vida = new VidaZerg(vidaInicial);
    }
    public void pasarTurno() {
        vida.pasarTurno();
    }

    

}
