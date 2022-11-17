package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Guardian extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 100;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 25;
    private static int RANGO_DE_ATAQUE = 10;
    private static int COSTO_MINERAL = 50;
    private static int COSTO_GASEOSO = 100;
    private static int TURNOS_PARA_CONSTRUIR = 4;

    public Guardian(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA);
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {

    }

    @Override
    int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
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

