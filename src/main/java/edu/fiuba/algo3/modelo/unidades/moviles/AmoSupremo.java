package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Danio;

public class AmoSupremo extends UnidadMovilZerg {

        private static int VIDA_MAXIMA = 200;
        //no tiene danio ni rango de ataque
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
                this.inventario.eliminarUnidad(this);
                this.inventario.agregarSuministro(COSTO_SUMINISTRO);
                throw new EstaDestruido("Unidad destruida");
            }
        }

        @Override
        public void ubicarEn(Casillero casillero){
            this.casillero = casillero;
            casillero.ocupar(this);
            casillero.quitarInvisibilidadEnRango(4);
        }

}
