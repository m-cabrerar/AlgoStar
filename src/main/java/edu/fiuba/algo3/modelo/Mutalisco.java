package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.exceptions.*;

public class Mutalisco extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 120;
    private static int DANIO_AIRE = 9;
    private static int DANIO_TIERRA = 9;
    private static int RANGO_DE_ATAQUE = 3;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 100;
    private static int TURNOS_PARA_CONSTRUIR = 7;

    private static int COSTO_SUMINISTRO = 4;

    private Danio danio;

    public Mutalisco(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Aire();
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    public void atacar(UnidadMovil unidadAAtacar) throws EstaDestruido{
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        unidadAAtacar.recibirDanio(danio);
    }

    public void evolucionarADevorador (Inventario inventario) throws RecursosInsuficientes {
        Devorador devorador = new Devorador(inventario);
        this.casillero.desocupar();
        //sacar del inventario
        new UnidadEnEvolucion(this.casillero, inventario, devorador);
    }
}
