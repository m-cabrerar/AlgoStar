package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ZerlingTests {
    @Test
    public void test01ZerlingAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Zerling zerling = new Zerling(inventarioMock);
        //ACT
        try {
            zerling.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ZerlingAtacaAUnidadTerrestreYLeHace4DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        Zerling zerling = new Zerling(inventarioMock);
        //ACT
        try {
            zerling.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(4);
        } catch (Exception e) {
            fail();
        }
    }
}
