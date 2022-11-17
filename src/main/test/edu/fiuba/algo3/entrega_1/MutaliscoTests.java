/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class MutaliscoTests {
    @Test
    public void test01MutaliscoAtacaAUnidadVoladorYLeHace9DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Mutalisco mutalisco = new Mutalisco(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            mutalisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(9,9);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02MutaliscoAtacaAUnidadTerrestreYLeHace9DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Mutalisco mutalisco = new Mutalisco(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            mutalisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(9,9);
        } catch (Exception e) {
            fail();
        }
    }
}
*/
