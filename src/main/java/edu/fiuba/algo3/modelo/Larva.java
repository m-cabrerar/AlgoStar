package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Larva extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 1;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 0;
    private static int RANGO_DE_ATAQUE = 0;
    private static int COSTO_MINERAL = 0;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 0;

    private static int COSTO_SUMINISTRO = 0; //supuesto
    private Danio danio;

    public Larva(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    public void recibirDanio(int danio) throws EstaDestruido {

    }

    public void atacar(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(danio);
    }

}
