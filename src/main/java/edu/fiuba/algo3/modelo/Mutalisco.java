package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Mutalisco extends UnidadMovilZerg{

    private static int VIDA_MAXIMA = 120;
    private static int DANIO_AIRE = 9;
    private static int DANIO_TIERRA = 9;
    private static int RANGO_DE_ATAQUE = 3;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 100;

    public int turnosParaConstruir(){
        return 7;
    }

    public boolean puedeVolar(){
        return true;
    }

    public Mutalisco(Casillero casillero, Inventario inventario){
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
        UnidadConcreta mutalisco = new Mutalisco(casillero, inventario);
        return new UnidadEnConstruccion(mutalisco, casillero, inventario);
    }

    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}
