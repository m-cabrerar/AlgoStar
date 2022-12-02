package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Asimilador;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;

public class NodoGas extends TipoCasillero {
    private int unidadesRestantes;

    public NodoGas(){
        unidadesRestantes = 5000;
    }
    @Override
    public int extraerGas(int cantidad) {
        unidadesRestantes -= cantidad;
        if (this.agotado()){
            return cantidad + unidadesRestantes;
        }
        return cantidad;
    }
    public boolean agotado(){
        return unidadesRestantes <= 0;
    }

    @Override
    public boolean ocupar(Extractor extractor){
        return true;
    }
    @Override
    public boolean ocupar(Asimilador asimilador){
        return true;
    }


}
