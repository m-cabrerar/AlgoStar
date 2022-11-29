package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

abstract class EdificioProtoss extends EdificioConcreto {
    protected int escudo;
    protected final int escudoMaximo;

    public EdificioProtoss(Casillero unCasillero, Inventario unInventario, int vidaInicial, int escudoInicial){
        super(unCasillero, unInventario, vidaInicial);
        this.escudo = escudoInicial;
        this.escudoMaximo = escudoInicial;
    }
    public void recibirDanio(int danio) throws EstaDestruido {
        if (this.estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        escudo -= danio;
        if (escudo < 0){
            this.vida += escudo;
            escudo = 0;
        }
        if (this.estaDestruido()){
            casillero.desocupar();
        }
    }
    public void pasarTurno(){
        super.pasarTurno();
        escudo += 10;
        if (escudo > escudoMaximo){
            escudo = escudoMaximo;
        }
    }
}
