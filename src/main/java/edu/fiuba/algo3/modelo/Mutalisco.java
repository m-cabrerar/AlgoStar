package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Mutalisco extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 120;
    private static int DANIO_AIRE = 9;
    private static int DANIO_TIERRA = 9;
    private static int RANGO_DE_ATAQUE = 3;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 100;
    private static int TURNOS_PARA_CONSTRUIR = 6;

    Mutalisco(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }

}
