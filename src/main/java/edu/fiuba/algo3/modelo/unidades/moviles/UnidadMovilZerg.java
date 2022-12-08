package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.VidaZerg;

public abstract class UnidadMovilZerg extends UnidadMovil{

    UnidadMovilZerg(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas, costoSuministro);
        this.vida = new VidaZerg(vidaInicial);
    }

    public void ubicarEn(Casillero casillero_){
        super.ubicarEn(casillero_);
        this.casillero.quitarInvisibilidadEnRango(1);
    }
    public void pasarTurno() {
        super.pasarTurno();
        this.casillero.quitarInvisibilidadEnRango(1);
        vida.pasarTurno();
    }

    

}
