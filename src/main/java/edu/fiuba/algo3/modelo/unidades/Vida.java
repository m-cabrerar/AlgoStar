package edu.fiuba.algo3.modelo.unidades;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.ModificablePorTurno;

abstract public class Vida implements Atacable, ModificablePorTurno {

    protected int vida;

    public Vida(int vida){
        this.vida = vida;
    }

    protected void chequeoDeVida(){
        if(!this.quedaVida()){
            throw new EstaDestruido("Unidad destruida");
        }
    }
    protected boolean quedaVida(){
        return (vida>0);
    }
}
