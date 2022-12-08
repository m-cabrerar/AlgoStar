package edu.fiuba.algo3.modelo.unidades.moviles;


import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.VidaProtoss;

public abstract class UnidadMovilProtoss extends UnidadMovil {

    UnidadMovilProtoss(Inventario inventario, int costoMineral, int costoGas, int vidaInicial, int escudoInicial, int costoSuministro){
        super(inventario, costoMineral, costoGas,costoSuministro);
        this.vida = new VidaProtoss(vidaInicial, escudoInicial);
    }

    public void pasarTurno() {
        super.pasarTurno();
        vida.pasarTurno();
    }
    public int getEscudo(){
        return vida.getEscudo();
    }
    public int getEscudoMaximo(){
        return vida.getEscudoMaximo();
    }
}
