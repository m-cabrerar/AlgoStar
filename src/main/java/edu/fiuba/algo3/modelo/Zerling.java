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
    public Zerling(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }
    public void atacar(UnidadMovil unidadAAtacar){
        if (unidadAAtacar.esVoladora()){
            unidadAAtacar.recibirDanio(DANIO_AIRE);
        }
        else{
            unidadAAtacar.recibirDanio(DANIO_TIERRA);
        }
    }
}
