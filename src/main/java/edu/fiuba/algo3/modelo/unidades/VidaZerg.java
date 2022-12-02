package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public class VidaZerg extends Vida implements Regenerativo{
    
    private int vidaMaxima;

    public VidaZerg(int cantidadVida){
        super(cantidadVida);
        this.vidaMaxima = cantidadVida;
    }

    public void sufrirAtaque(int danio) throws EstaDestruido {
        this.vida -= danio;
        this.chequeoDeVida();
    }

    public void regenerar(){
        this.vida += 10;
        if (vida > vidaMaxima){
            this.vida = vidaMaxima;
        }
        if (vida < 0){
            this.vida = 0;
        }
    }

    public void pasarTurno(){
        this.regenerar();
    }
}
