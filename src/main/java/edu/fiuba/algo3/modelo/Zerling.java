package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

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
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        if (unidadAAtacar.esVoladora()){
            unidadAAtacar.recibirDanio(DANIO_AIRE);
        }
        else{
            unidadAAtacar.recibirDanio(DANIO_TIERRA);
        }
    }
}
