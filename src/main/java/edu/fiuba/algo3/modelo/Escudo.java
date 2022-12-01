package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.EstaDestruido;

public class Escudo implements Regenerativo, Atacable {
    
    private int escudo;
    private int escudoMaximo;

    public Escudo(int escudo){
        this.escudo = escudo;
        this.escudoMaximo = escudo;
    }

    public void regenerar(){
        this.escudo += 10;
        if (escudo > escudoMaximo){
            this.escudo = escudoMaximo;
        }
        if (escudo < 10){
            this.escudo = 10;
        }
    }

    public void sufrirAtaque(int danio){
        this.chequeoDeEscudo();
        this.escudo -= danio;
    }

    private void chequeoDeEscudo(){
        if(!this.quedaEscudo()){
            throw new EstaDestruido("Unidad destruida");
        }
    }

    private boolean quedaEscudo(){
        return (escudo>=0);
    }
}
