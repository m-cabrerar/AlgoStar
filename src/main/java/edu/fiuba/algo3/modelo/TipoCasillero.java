package edu.fiuba.algo3.modelo;
import java.util.List;

public abstract class TipoCasillero{
    public abstract String nombreDelCasillero();

    public void extraerMineral(Inventario inventario, int cantidad){}

    public void expandirMoho(List<Casillero> casillasAContagiar){}

    public void extraerGas(Inventario unDestinoDeRecoleccion, int cantidadRecolectada){}
}
