package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ScoutTests {
    @Test
    public void test01ScoutAtacaAUnidadVoladorYLeHace14DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Scout scout = new Scout(inventarioMock);
        //ACT
        try {
            scout.ubicarEn(casilleroMock);
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
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Scout scout = new Scout(inventarioMock);
        //ACT
        try {
            scout.ubicarEn(casilleroMock);
            scout.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(8);
        } catch (Exception e) {
            fail();
        }
    }
    public void test03ScoutNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Scout scout = new Scout(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            scout.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> scout.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}
