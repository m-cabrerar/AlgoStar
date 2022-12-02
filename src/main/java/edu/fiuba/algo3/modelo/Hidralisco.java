package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Hidralisco extends UnidadMovilZerg {

    private static int VIDA_MAXIMA = 80;
    private static int DANIO_AIRE = 10;
    private static int DANIO_TIERRA = 10;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 75;
    private static int COSTO_GASEOSO = 25;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    private static int COSTO_SUMINISTRO = 2;

    private Danio danio;

    public Hidralisco(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Tierra();
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    public void atacar(Unidad unidadAAtacar){
        try{
            super.atacar(unidadAAtacar, RANGO_DE_ATAQUE, danio);
        } catch (Exception EstaDestruido){
            //no tiene comportamiento si mata una unidad
        }
    }
}
