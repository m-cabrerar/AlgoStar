package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Zerling extends UnidadMovil {

    private static int VIDA_MAXIMA = 35;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 4;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 25;
    private static int COSTO_GASEOSO = 0;
    Zerling(Inventario inventario){
        if(!inventario.tieneRecursos(25,0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
    }
    public int turnosParaConstruir(){
        return 2;
    }
}
