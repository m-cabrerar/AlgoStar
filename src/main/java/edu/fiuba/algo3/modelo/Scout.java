package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

public class Scout extends UnidadMovilProtoss{

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 60;
    private static int DANIO_AIRE = 14;
    private static int DANIO_TIERRA = 8;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 300;
    private static int COSTO_GASEOSO = 150;

    public Scout(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, VIDA_MAXIMA, ESCUDO_MAXIMO);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public static UnidadEnConstruccion construir(Casillero casillero, Inventario inventario) {
        UnidadConcreta scout = new Scout(casillero, inventario);
        if(!inventario.tieneRecursos(COSTO_MINERAL, COSTO_GASEOSO)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        return new UnidadEnConstruccion(scout, casillero, inventario);
    }
    public int turnosParaConstruir(){
        return 9;
    }

    public boolean puedeVolar(){
        return true;
    }
    public void atacar(Unidad unidadAAtacar) {
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }
}
