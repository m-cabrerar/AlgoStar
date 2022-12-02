package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

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
            inventario.agregarSuministro(SUMINISTRA);
            superficie = new Aire();
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
                throw new EstaDestruido("Unidad destruida");
            }
        }

}
