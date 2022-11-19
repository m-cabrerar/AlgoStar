package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ZerlingTests {
    @Test
    public void test01ZerlingAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Zerling zerling = new Zerling(inventarioMock);
        //ACT
        try {
            zerling.ubicarEn(casilleroMock);
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
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Zerling zerling = new Zerling(inventarioMock);
        //ACT
        try {
            zerling.ubicarEn(casilleroMock);
            zerling.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(4);
        } catch (Exception e) {
            fail();
        }
    }
    public void test03ZerlingNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Zerling zerling = new Zerling(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            zerling.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> zerling.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}
