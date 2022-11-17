package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ZealotTests {
    @Test
    public void test01ZealotAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Zealot zealot = new Zealot(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            zealot.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8,0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ZealotAtacaAUnidadTerrestreYLeHace8DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Zealot zealot = new Zealot(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            zealot.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8,0);
        } catch (Exception e) {
            fail();
        }
    }
}
