/*
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class MutaliscoTests {
    @Test
    public void test01MutaliscoAtacaAUnidadVoladorYLeHace9DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);
        //ACT
        try {
            mutalisco.ubicarEn(casilleroMock);
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
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        //ACT
        try {
            mutalisco.ubicarEn(casilleroMock);
            mutalisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(9);
        } catch (Exception e) {
            fail();
        }
    }

    public void test03MutaliscoNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            mutalisco.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> mutalisco.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}

 */
