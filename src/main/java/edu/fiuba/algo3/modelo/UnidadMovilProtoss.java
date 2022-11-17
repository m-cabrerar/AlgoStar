package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public abstract class UnidadMovilProtoss extends UnidadConcreta {
    private int escudo;
    private final int escudoMaximo;
    public UnidadMovilProtoss(Casillero unCasillero, Inventario unInventario, int vidaInicial, int escudoInicial){
        super(unCasillero, unInventario, vidaInicial);
        this.escudo = escudoInicial;
        this.escudoMaximo = escudoInicial;
    }

    public void recibirDanio(int danioTierra, int danioAire) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("Esta unidad fue destruida");
        }
        if(this.puedeVolar()) {
            escudo -= danioAire;
        }
        else {
            escudo -= danioTierra;
        }
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
