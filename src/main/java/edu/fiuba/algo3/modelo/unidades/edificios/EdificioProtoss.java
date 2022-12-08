package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.CasilleroNoCompatible;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.VidaProtoss;

public abstract class EdificioProtoss extends EdificioConcreto {
    public EdificioProtoss(Casillero unCasillero, Inventario unInventario, int vidaInicial, int escudoInicial){
        super(unCasillero, unInventario);
        this.vida = new VidaProtoss(vidaInicial, escudoInicial);
    }

    public void pasarTurno() throws CasilleroNoCompatible {
        super.pasarTurno();
        this.vida.pasarTurno();
    }
    public int getEscudo(){
        return this.vida.getEscudo();
    }
    public int getEscudoMaximo(){
        return this.vida.getEscudoMaximo();
    }

    public void chequeoCasillero() throws CasilleroNoCompatible{
        if(!this.casillero.tieneEnergia()){
            throw new CasilleroNoCompatible("El casillero no tiene mas energia");
        }
    }
}
