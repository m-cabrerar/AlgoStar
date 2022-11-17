/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ScoutTests {
    @Test
    public void test01ScoutAtacaAUnidadVoladorYLeHace14DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Scout scout = new Scout(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            scout.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8,14);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ScoutAtacaAUnidadTerrestreYLeHace8DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Scout scout = new Scout(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            scout.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8,14);
        } catch (Exception e) {
            fail();
        }
    }
}
*/
