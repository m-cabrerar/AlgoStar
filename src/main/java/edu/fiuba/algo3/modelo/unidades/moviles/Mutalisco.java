package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.UnidadEnEvolucion;

public class Mutalisco extends UnidadMovilZerg {
    private static int VIDA_MAXIMA = 120;
    private static int DANIO_AIRE = 9;
    private static int DANIO_TIERRA = 9;
    private static int RANGO_DE_ATAQUE = 3;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 100;
    private static int TURNOS_PARA_CONSTRUIR = 7;
    private static int COSTO_SUMINISTRO = 4;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 3;

    public Mutalisco(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Aire();
        this.rangoDeAtaque = RANGO_DE_ATAQUE;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }

    public void pasarTurno(){
        super.pasarTurno();
    }

    public void evolucionarAGuardian(){
        Guardian guardian = new Guardian(inventario);
        this.casillero.desocupar();
        this.inventario.unidadAEliminar(this);
        new UnidadEnEvolucion(this.casillero, inventario, guardian);
    }
    public void evolucionarADevorador() throws RecursosInsuficientes, SuministrosInsuficientes, PoblacionMaximaAlcanzada {
        Devorador devorador = new Devorador(inventario);
        this.casillero.desocupar();
        this.inventario.unidadAEliminar(this);
        new UnidadEnEvolucion(this.casillero, inventario, devorador);
    }
    public void recibirDanio(Danio danio) throws EstaDestruido {
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.unidadAEliminar(this);
            this.inventario.devolverSuministrosUnidad(COSTO_SUMINISTRO);
            throw new EstaDestruido("Unidad destruida");
        }
    }
    public static boolean puedeConstruirseEn(Inventario inventario){
        return inventario.puedeConstruir(NIVEL_DE_CONSTRUCCION_REQUERIDO);
    }
}
