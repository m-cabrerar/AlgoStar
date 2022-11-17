package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ScoutTests {
    @Test
    public void test01ScoutAtacaAUnidadVoladorYLeHace14DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Scout scout = new Scout(inventarioMock);
        //ACT
        try {
            scout.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(14);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ScoutAtacaAUnidadTerrestreYLeHace8DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        Scout scout = new Scout(inventarioMock);
        //ACT
        try {
            scout.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8);
        } catch (Exception e) {
            fail();
        }
    }
}
