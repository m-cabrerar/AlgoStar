package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.exceptions.*;

public class Scout extends UnidadMovilProtoss {

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 60;
    private static int DANIO_AIRE = 14;
    private static int DANIO_TIERRA = 8;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 300;
    private static int COSTO_GASEOSO = 150;
    private static int TURNOS_PARA_CONSTRUIR = 9;

    private static int COSTO_SUMINISTRO = 4;

    private Danio danio;

    public Scout(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Aire();
    }

    @Override
    public void recibirDanio(Danio danio) throws EstaDestruido {
        vida.sufrirAtaque(superficie.danio(danio));
    }

    @Override
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public void atacar(UnidadMovil unidadAAtacar){
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        unidadAAtacar.recibirDanio(danio);
    }
}
