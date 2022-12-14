package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.moviles.Scout;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class caso3 {

    @Test
    public void Test01PeleaEntreHidraliscoYScoutHastaQueHidraliscoMuere(){

        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarMineral(175);
        inventario.agregarGas(175);
        inventario.agregarSuministro(8);

        Mapa mapa = new Mapa(10,10);

        mapa.cambiarTipoCasilla(1,1,new CasilleroVacio());
        Casillero casilleroHidra = mapa.obtenerCasillero(1,1);

        mapa.cambiarTipoCasilla(2,2,new CasilleroVacio());
        Casillero casilleroScout = mapa.obtenerCasillero(1,2);

        Hidralisco hidra = new Hidralisco(inventario); //terrestre, vida 80
        Scout scout = new Scout(inventario); //aereo, escudo 100, vida 150

        //ACT
        hidra.ubicarEn(casilleroHidra);
        scout.ubicarEn(casilleroScout);

        for(int i=0; i<12; i++){
            hidra.atacar(scout); //hidra hace 10 de daño
            scout.pasarTurno(); //regenera 1 de vida
            scout.atacar(hidra); //scout hace 8 de daño
            hidra.pasarTurno(); //regenera 1 de escudo
        }

        //ASSERT
        //assert que el casillero esta vacio
        assertEquals(casilleroHidra.estaOcupado(),false);

    }
}
