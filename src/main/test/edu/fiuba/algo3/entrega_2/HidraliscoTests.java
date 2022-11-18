/*
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class HidraliscoTests {
    @Test
    public void test01HidraliscoAtacaAUnidadVoladorYLeHace10DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Hidralisco hidra = new Hidralisco(inventarioMock);
        //ACT
        try {
            hidra.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(10);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02HidraliscoAtacaAUnidadTerrestreYLeHace10DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        Hidralisco hidralisco = new Hidralisco(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            hidralisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(10);
        } catch (Exception e) {
            fail();
        }
    }

}
 */
