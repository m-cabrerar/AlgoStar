package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Zerling extends UnidadMovilZerg{

    private static int VIDA_MAXIMA = 35;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 4;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 25;
    private static int COSTO_GASEOSO = 0;

    public int turnosParaConstruir(){
        return 2;
    }

    public boolean puedeVolar(){
        return false;
    }

    public Zerling(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA_MAXIMA);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public static UnidadEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(COSTO_MINERAL,COSTO_GASEOSO)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        UnidadConcreta zerling = new Zerling(casillero, inventario);
        return new UnidadEnConstruccion(zerling, casillero, inventario);
    }
    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}
