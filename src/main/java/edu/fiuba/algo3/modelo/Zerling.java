package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Zerling extends UnidadMovilZerg {

    private static int VIDA_MAXIMA = 35;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 4;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 25;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 2;

    private static int COSTO_SUMINISTRO = 1;

    private Danio danio;

    public Zerling(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Tierra();
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    public void recibirDanio(Danio danio) throws EstaDestruido {
        vida.sufrirAtaque(superficie.danio(danio));
    }
    public void atacar(UnidadMovil unidadAAtacar) throws EstaDestruido{
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        unidadAAtacar.recibirDanio(danio);
    }
}
