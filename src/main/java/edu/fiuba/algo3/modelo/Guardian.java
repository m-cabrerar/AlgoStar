package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Guardian extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 100;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 25;
    private static int RANGO_DE_ATAQUE = 10;
    private static int COSTO_MINERAL = 50;
    private static int COSTO_GASEOSO = 100;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    private static int COSTO_SUMINISTRO = 0;

    private Danio danio;

    public Guardian(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Aire();
    }

    @Override
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public void atacar(UnidadMovil unidadAAtacar){
        try{
            super.atacar(unidadAAtacar, RANGO_DE_ATAQUE, danio);
        } catch (Exception EstaDestruido){
            //no tiene comportamiento si mata una unidad
        }
    }
}

