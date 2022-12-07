package edu.fiuba.algo3.modelo.unidades;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.ModificablePorTurno;

abstract public class Vida implements Atacable, ModificablePorTurno {

    protected int vida;
    protected int vidaMaxima;

    public Vida(int vida){
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    protected void chequeoDeVida(){
        if(!this.quedaVida()){
            throw new EstaDestruido("Unidad destruida");
        }
    }
    protected boolean quedaVida(){
        return (vida>0);
    }

    public int getVida(){
        return vida;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public abstract int getEscudo();
    public abstract int getEscudoMaximo();

}

