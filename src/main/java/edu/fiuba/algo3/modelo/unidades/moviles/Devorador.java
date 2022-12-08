package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Devorador extends UnidadMovilZerg {
    
    private static final int VIDA = 200;
    private static final int DANIO_AIRE = 0;
    private static final int DANIO_TIERRA = 15;
    private static final int RANGO_DE_ATAQUE = 5;
    private static final int COSTO_MINERAL = 150;
    private static final int COSTO_GASEOSO = 50;
    private static final int TURNOS_PARA_CONSTRUIR = 4;

    private static final int COSTO_SUMINISTRO = 0;


    public Devorador(Inventario inventario) {
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Aire();
        this.rangoDeAtaque = RANGO_DE_ATAQUE;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }
    @Override
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
