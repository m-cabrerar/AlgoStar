package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

public class Zealot extends UnidadMovilProtoss {

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 60;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 8;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    Zealot(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO);
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }

    @Override
    int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }
}
