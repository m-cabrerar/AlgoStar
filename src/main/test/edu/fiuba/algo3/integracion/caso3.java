package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.exceptions.UbicacionInvalida;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Acceso;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class caso3 {

    @Test
    public void test01EdificioZergSeConstruyeSobreCasilleroEnergizado() {
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarMineral(50);

        Mapa mapa = new Mapa(20,20);

        Casillero casilleroPilon = mapa.obtenerCasillero(2,2);
        Casillero casilleroAccesoConEnergia = mapa.obtenerCasillero(2,1);
        Casillero casilleroAccesoSinEnergia = mapa.obtenerCasillero(7,8);

        //ACT
        Pilon.construir(casilleroPilon,inventario);
        for(int i=0; i<5; i++){
            inventario.pasarTurno();
        }
        //ASSERT
        assertThrows(UbicacionInvalida.class, () -> Acceso.construir(casilleroAccesoSinEnergia,inventario));
        assertDoesNotThrow(() -> Acceso.construir(casilleroAccesoConEnergia,inventario));
    }
}
