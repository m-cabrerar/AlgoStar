package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Hidralisco extends UnidadMovil {

    private static int VIDA_MAXIMA = 80;
    private static int DANIO_AIRE = 10;
    private static int DANIO_TIERRA = 10;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 75;
    private static int COSTO_GASEOSO = 25;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    Hidralisco(Inventario inventario){
        if(!inventario.tieneRecursos(75,25)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }
}
