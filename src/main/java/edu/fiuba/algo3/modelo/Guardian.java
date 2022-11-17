package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Guardian extends UnidadMovilZerg{
    private static int VIDA_MAXIMA = 100;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 25;
    private static int RANGO_DE_ATAQUE = 10;
    private static int COSTO_MINERAL = 50;
    private static int COSTO_GASEOSO = 100;

    public Guardian(Casillero casillero, Inventario inventario){
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
        UnidadConcreta guardian = new Guardian(casillero, inventario);
        return new UnidadEnConstruccion(guardian, casillero, inventario);
    }
    public int turnosParaConstruir(){
        return 4;
    }

    public boolean puedeVolar(){
        return true;
    }
    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}

