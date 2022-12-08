package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Zangano extends UnidadMovilZerg{
    private static final int VIDA = 25;
    private static final int DANIO_AIRE = 0;
    private static final int DANIO_TIERRA = 0;
    private static final int RANGO = 0;
    private static final int TURNOS_PARA_CONSTRUIR = 1;
    private static final int COSTO_GASEOSO = 0;
    private static final int COSTO_MINERAL = 25;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    private static int COSTO_SUMINISTRO = 1;

    public Zangano(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Tierra();
        this.rangoDeAtaque = RANGO;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }

    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public void recibirDanio(Danio danio) throws EstaDestruido {
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.eliminarUnidad(this);
            this.inventario.devolverSuministrosUnidad(COSTO_SUMINISTRO);
            throw new EstaDestruido("Unidad destruida");
        }
    }

}
