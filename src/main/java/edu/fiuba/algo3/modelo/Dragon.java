package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Dragon extends UnidadMovilProtoss{

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 80;
    private static int DANIO_AIRE = 20;
    private static int DANIO_TIERRA = 20;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 125;
    private static int COSTO_GASEOSO = 50;

    public Dragon(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, VIDA_MAXIMA, ESCUDO_MAXIMO);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public static UnidadEnConstruccion construir(Casillero casillero, Inventario inventario) {
        UnidadConcreta dragon = new Dragon(casillero, inventario);
        if(!inventario.tieneRecursos(COSTO_MINERAL, COSTO_GASEOSO)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        return new UnidadEnConstruccion(dragon, casillero, inventario);
    }
    public int turnosParaConstruir(){
        return 6;
    }

    public boolean puedeVolar(){
        return false;
    }

    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}
