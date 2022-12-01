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

    public void atacar(UnidadMovil unidadAAtacar){
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        try {
            unidadAAtacar.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            throw new EstaDestruido("Edificio Destruido");
        }

    }
}
