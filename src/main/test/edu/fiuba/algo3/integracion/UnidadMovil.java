package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.CasilleroEspacial;
import edu.fiuba.algo3.modelo.casillero.Moho;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.moviles.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadMovil {

    
    public void test01DragonRompeUnEdificio() {
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarMineral(125);
        inventario.agregarGas(50);
        inventario.agregarSuministro(3);

        Mapa mapa = new Mapa(10,10);

        Casillero casilleroEdificio = new Casillero(2,1,mapa);
        casilleroEdificio.setTipoCasillero(new NodoGas());
        Casillero casilleroDragon = new Casillero(1,1,mapa);
        casilleroDragon.setTipoCasillero(new Moho());

        Dragon dragon = new Dragon(inventario);
        Extractor edificio = new Extractor(casilleroEdificio,inventario);

        //ACT
        dragon.ubicarEn(casilleroDragon);
        edificio.ubicarEnInventario();

        //loop
        for(int i=0; i<1; i++){ //dragon saca 20, pega 38
            dragon.atacar(edificio);
        }
        //ASSERT
        //assert que el casillero esta vacio
        assertEquals(casilleroEdificio.estaOcupado(),false);
    }

}
