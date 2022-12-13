package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Danio;

public class AmoSupremo extends UnidadMovilZerg {

        private static int VIDA_MAXIMA = 200;
        private static int DANIO_AIRE = 0;
        private static int DANIO_TIERRA = 0;
        private static int RANGO_DE_ATAQUE = 0;
        private static int COSTO_MINERAL = 50;
        private static int COSTO_GASEOSO = 0;
        private static int TURNOS_PARA_CONSTRUIR = 5;

        private static int COSTO_SUMINISTRO = 0;
        private static int SUMINISTRA = 5;

        public AmoSupremo(Inventario inventario){
            super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
            inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
            superficie = new Aire();
            inventario.agregarSuministro(SUMINISTRA);
            this.rangoDeAtaque = RANGO_DE_ATAQUE;
            this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
        }

        public int turnosParaConstruir(){
            return TURNOS_PARA_CONSTRUIR;
        }
        
        //Amo supremo no ataca

        public void recibirDanio(Danio danio) throws EstaDestruido {
            try {
                super.recibirDanio(danio);
            } catch (Exception EstaDestruido){
                this.inventario.perderSuministro(SUMINISTRA);
                this.inventario.unidadAEliminar(this);
                this.inventario.devolverSuministrosUnidad(COSTO_SUMINISTRO);
                throw new EstaDestruido("Unidad destruida");
            }
        }

        @Override
        public void ubicarEn(Casillero casillero){
            super.ubicarEn(casillero);
            casillero.quitarInvisibilidadEnRango(4);
        }

    @Override
    public void pasarTurno() {
        super.pasarTurno();
        casillero.quitarInvisibilidadEnRango(4);
    }
}
