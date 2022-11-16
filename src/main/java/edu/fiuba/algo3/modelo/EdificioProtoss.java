package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

import java.lang.invoke.CallSite;

abstract class EdificioProtoss extends EdificioConcreto {
    private int escudo;
    private final int escudoMaximo;

    public EdificioProtoss(Casillero unCasillero, Inventario unInventario, int vidaInicial, int escudoInicial){
        super(unCasillero, unInventario, vidaInicial);
        this.escudo = escudoInicial;
        this.escudoMaximo = escudoInicial;
    }

    public void recibirDanio(int danio) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        escudo -= danio;
        if (escudo < 0){
            vida += escudo;
            escudo = 0;
        }
        if (estaDestruido()){
            casillero.desocupar();
        }
    }

    public void pasarTurno(){
        escudo += 10;
        if (escudo > escudoMaximo){
            escudo = escudoMaximo;
        }
    }
}
