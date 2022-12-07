package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public class VidaZerg extends Vida implements Regenerativo{
    public VidaZerg(int cantidadVida){
        super(cantidadVida);
    }

    public void sufrirAtaque(int danio) throws EstaDestruido {
        this.vida -= danio;
        this.chequeoDeVida();
    }

    public void regenerar(){
        this.vida += 10;
        if (vida > this.vidaMaxima){
            this.vida = this.vidaMaxima;
        }
        if (vida < 0){
            this.vida = 0;
        }
    }

    public void pasarTurno(){
        this.regenerar();
    }

    public int getEscudo(){
        return 0;
    }
    public int getEscudoMaximo(){
        return 0;
    }
}
