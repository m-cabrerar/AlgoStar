package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.EstaDestruido;

abstract public class Vida implements Atacable, ModificablePorTurno{

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
