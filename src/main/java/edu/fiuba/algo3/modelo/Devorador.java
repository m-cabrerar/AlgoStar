package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
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

    private Danio danio;

    public Devorador(Inventario inventario) {
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
        superficie = new Aire();
    }
    @Override
    public int turnosParaConstruir() {
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
