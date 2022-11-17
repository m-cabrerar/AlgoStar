/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class GuardianTests {
    @Test
    public void test01GuardianAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Guardian guardian = new Guardian(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            guardian.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(25,0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02GuardianAtacaAUnidadTerrestreYLeHace25DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Guardian guardian = new Guardian(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            guardian.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(25,0);
        } catch (Exception e) {
            fail();
        }
    }
}
*/
