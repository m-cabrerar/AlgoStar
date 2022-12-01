package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Dragon extends UnidadMovilProtoss {

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 80;
    private static int DANIO_AIRE = 20;
    private static int DANIO_TIERRA = 20;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 125;
    private static int COSTO_GASEOSO = 50;
    private static int TURNOS_PARA_CONSTRUIR = 6;

    private static int COSTO_SUMINISTRO = 3;

    private Danio danio;

    public Dragon(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Tierra();
    }

    @Override
    public void recibirDanio(Danio danio) throws EstaDestruido {
        vida.sufrirAtaque(superficie.danio(danio));
    }

    @Override
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    // TODO: refactor
    public void atacar(UnidadMovil unidadAAtacar){
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        try{
            unidadAAtacar.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            throw new EstaDestruido("Edificio Destruido");
        }

    }


}
