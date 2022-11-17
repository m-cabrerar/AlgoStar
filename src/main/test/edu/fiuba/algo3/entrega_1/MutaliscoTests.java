package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class MutaliscoTests {
    @Test
    public void test01MutaliscoAtacaAUnidadVoladorYLeHace9DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        //ACT
        try {
            mutalisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(9);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02MutaliscoAtacaAUnidadTerrestreYLeHace9DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        //ACT
        try {
            mutalisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(9);
        } catch (Exception e) {
            fail();
        }
    }
}
