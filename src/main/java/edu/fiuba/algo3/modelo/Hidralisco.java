package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Hidralisco extends UnidadMovilZerg{

    private static int VIDA_MAXIMA = 80;
    private static int DANIO_AIRE = 10;
    private static int DANIO_TIERRA = 10;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 75;
    private static int COSTO_GASEOSO = 25;

    public int turnosParaConstruir(){
        return 4;
    }

    public boolean puedeVolar(){
        return false;
    }

    public Hidralisco(Casillero casillero, Inventario inventario){
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
        UnidadConcreta hidralisco = new Hidralisco(casillero, inventario);
        return new UnidadEnConstruccion(hidralisco, casillero, inventario);
    }

    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}
