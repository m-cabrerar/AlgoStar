package edu.fiuba.algo3.modelo.unidades;
import edu.fiuba.algo3.exceptions.EstaDestruido;

public class Escudo implements Regenerativo, Atacable {
    
    private int escudo;
    private int escudoMaximo;

    public Escudo(int escudo){
        this.escudo = escudo;
        this.escudoMaximo = escudo;
    }

    public void regenerar(){
        this.escudo += 1;
        if (escudo > escudoMaximo){
            this.escudo = escudoMaximo;
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
        return (escudo>0);
    }

    public int getEscudo(){
        return escudo;
    }
    public int getEscudoMaximo(){
        return escudoMaximo;
    }
}
