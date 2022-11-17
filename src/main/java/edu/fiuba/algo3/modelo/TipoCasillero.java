package edu.fiuba.algo3.modelo;
import java.util.List;

public abstract class TipoCasillero{
    public abstract String nombreDelCasillero();

    public int extraerMineral(int cantidad){
        return 0;
    }
    public int extraerGas(int cantidad){
        return 0;
    }
    public void expandirMoho(List<Casillero> casillasAContagiar){}


}
