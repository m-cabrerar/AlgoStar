package edu.fiuba.algo3.modelo;

public class VidaProtoss extends Vida {

    private Escudo escudo;

    public VidaProtoss(int vida, int escudo){
        super(vida);
        this.escudo = new Escudo(escudo);
    }

    public void sufrirAtaque(int danio){
        try{
            this.escudo.sufrirAtaque(danio);
        } catch (Exception EstaDestruido) {
            this.vida -= danio;
            super.chequeoDeVida();
        }
    }

    public void pasarTurno(){
        this.escudo.regenerar();
    }

    
}
