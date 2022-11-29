package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public class Devorador extends UnidadMovilZerg {
    private static final int VIDA = 200;
    private static final int DANIO_AIRE = 0;
    private static final int DANIO_TIERRA = 15;
    private static final int RANGO_DE_ATAQUE = 5;
    private static final int COSTO_MINERAL = 150;
    private static final int COSTO_GASEOSO = 50;
    private static final int TURNOS_PARA_CONSTRUIR = 4;

    private static final int COSTO_SUMINISTRO = 0;

    Devorador(Inventario inventario) {
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA, COSTO_SUMINISTRO);
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }

    @Override
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }
}
