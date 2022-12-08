package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.Moho;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.moviles.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class caso2 {

    @Test
    public void test01DragonRompeUnEdificio() {
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarMineral(125);
        inventario.agregarGas(50);
        inventario.agregarSuministro(3);

        Mapa mapa = new Mapa(10,10);

        mapa.cambiarTipoCasilla(1,1,new NodoGas());
        Casillero casilleroEdificio = mapa.obtenerCasillero(1,1);

        mapa.cambiarTipoCasilla(2,2,new Moho());
        Casillero casilleroDragon = mapa.obtenerCasillero(2,2);

        Dragon dragon = new Dragon(inventario);
        Extractor edificio = new Extractor(casilleroEdificio,inventario);

        //ACT
        dragon.ubicarEn(casilleroDragon);
        edificio.ubicarEnInventario();

        //loop
        for(int i=0; i<38; i++){ //dragon saca 20, pega 38
            dragon.atacar(edificio);
            dragon.pasarTurno();
        }
        //ASSERT
        //assert que el casillero esta vacio
        assertEquals(casilleroEdificio.estaOcupado(),false);
    }

}
