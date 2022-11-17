package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Hidralisco extends UnidadMovilZerg {

    private static int VIDA_MAXIMA = 80;
    private static int DANIO_AIRE = 10;
    private static int DANIO_TIERRA = 10;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 75;
    private static int COSTO_GASEOSO = 25;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    Hidralisco(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }
}
