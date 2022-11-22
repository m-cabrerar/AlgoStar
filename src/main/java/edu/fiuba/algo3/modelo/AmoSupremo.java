package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class AmoSupremo extends UnidadMovilZerg {

        private static int VIDA_MAXIMA = 200;
        private static int DANIO_AIRE = 0;
        private static int DANIO_TIERRA = 0;
        private static int RANGO_DE_ATAQUE = 0;
        private static int COSTO_MINERAL = 50;
        private static int COSTO_GASEOSO = 0;
        private static int TURNOS_PARA_CONSTRUIR = 5;

        private static int COSTO_SUMINISTRO = 0;

        public AmoSupremo(Inventario inventario){
            super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, COSTO_SUMINISTRO);
            inventario.agregarSuministro(5);
        }
        public int turnosParaConstruir(){
            return TURNOS_PARA_CONSTRUIR;
        }
        public void atacar(UnidadMovil unidadAAtacar){
            if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
                throw new AtaqueFueraDeRango("El ataque está fuera de rango");
            }
            if (unidadAAtacar.esVoladora()){
                unidadAAtacar.recibirDanio(DANIO_AIRE);
            }
            else{
                unidadAAtacar.recibirDanio(DANIO_TIERRA);
            }
        }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido {
    }
}
