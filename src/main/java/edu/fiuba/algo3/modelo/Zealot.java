package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;

public class Zealot extends UnidadMovilProtoss{

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 60;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 8;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 0;
    public Zealot(Casillero unCasillero, Inventario unInventario){
        super(unCasillero, unInventario, VIDA_MAXIMA, ESCUDO_MAXIMO);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public static UnidadEnConstruccion construir(Casillero casillero, Inventario inventario) {
        UnidadConcreta zealot = new Zealot(casillero, inventario);
        if(!inventario.tieneRecursos(COSTO_MINERAL, COSTO_GASEOSO)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        return new UnidadEnConstruccion(zealot, casillero, inventario);
    }
    public int turnosParaConstruir(){
        return 4;
    }

    public boolean puedeVolar(){
        return false;
    }

    public void atacar(Unidad unidadAAtacar){
        super.atacar(unidadAAtacar, DANIO_AIRE, DANIO_TIERRA);
    }

}
