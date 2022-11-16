package edu.fiuba.algo3.modelo;
import java.util.List;

public abstract class TipoCasillero{
    public abstract void pasarTurno();

    public abstract String nombreDelCasillero();

    public void extraerMineral(int cantidad){}
    public void extraerGas(int cantidad){}

    public void expandirMoho(List<Casillero> casillasAContagiar){}

    public void extraerGas(Inventario unDestinoDeRecoleccion, int cantidadRecolectada){}
}