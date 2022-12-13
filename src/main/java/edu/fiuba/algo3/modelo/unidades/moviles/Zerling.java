package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Tierra;

public class Zerling extends UnidadMovilZerg {

    private static int VIDA_MAXIMA = 35;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 4;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 25;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 2;
    private static int COSTO_SUMINISTRO = 1;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 1;

    public Zerling(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Tierra();
        this.rangoDeAtaque = RANGO_DE_ATAQUE;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
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
