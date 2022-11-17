/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ZerlingTests {
    @Test
    public void test01ZerlingAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Zerling zerling = new Zerling(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            zerling.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(4,0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ZerlingAtacaAUnidadTerrestreYLeHace4DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Zerling zerling = new Zerling(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            zerling.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(4,0);
        } catch (Exception e) {
            fail();
        }
    }
}
*/
