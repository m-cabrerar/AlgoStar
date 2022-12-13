package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Tierra;

public class Dragon extends UnidadMovilProtoss {

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 80;
    private static int DANIO_AIRE = 20;
    private static int DANIO_TIERRA = 20;
    private static int RANGO_DE_ATAQUE = 4;
    private static int COSTO_MINERAL = 125;
    private static int COSTO_GASEOSO = 50;
    private static int TURNOS_PARA_CONSTRUIR = 6;

    private static int COSTO_SUMINISTRO = 3;


    public Dragon(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Tierra();
        this.rangoDeAtaque = RANGO_DE_ATAQUE;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }

    @Override
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    // TODO: refactor

    public void recibirDanio(Danio danio) throws EstaDestruido {
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.unidadAEliminar(this);
            this.inventario.devolverSuministrosUnidad(COSTO_SUMINISTRO);
            throw new EstaDestruido("Unidad destruida");
        }
    }
}
