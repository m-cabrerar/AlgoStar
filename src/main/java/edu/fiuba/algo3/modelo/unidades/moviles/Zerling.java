package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Zerling extends UnidadMovilZerg {

    private static int VIDA_MAXIMA = 35;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 4;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 25;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 2;

    private static int COSTO_SUMINISTRO = 1;

    private Danio danio;

    public Zerling(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Tierra();
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }
    public void atacar(Unidad unidadAAtacar){
        try{
            super.atacar(unidadAAtacar, RANGO_DE_ATAQUE, danio);
        } catch (Exception EstaDestruido){
            //no tiene comportamiento si mata una unidad
        }
    }
    public void recibirDanio(Danio danio) throws EstaDestruido {
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.eliminarUnidad(this);
            this.inventario.agregarSuministro(COSTO_SUMINISTRO);
            throw new EstaDestruido("Unidad destruida");
        }
    }
}
