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
    public void ocupar(Extractor extractor){
        return;
    }
    @Override
    public void ocupar(Asimilador asimilador){
        return;
    }


}
