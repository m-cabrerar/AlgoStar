package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GuardianTests {
    @Test
    public void test01GuardianAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE

        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Guardian guardian = new Guardian(inventarioMock);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        //ACT
        try {
            guardian.ubicarEn(casilleroMock);
            for(int i=0; i<30; i++){
                guardian.atacar(mutalisco);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(0)).desocupar();
    }

    @Test
    public void test02GuardianAtacaAUnidadTerrestreYLeHace25DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Guardian guardian = new Guardian(inventarioMock);
        Hidralisco hidra = new Hidralisco(inventarioMock);
        //ACT
        try {
            guardian.ubicarEn(casilleroMock);
            hidra.ubicarEn(casilleroMock);
            for(int i=0; i<4; i++){
                guardian.atacar(hidra);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    public void test03GuardianNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Guardian guardian = new Guardian(inventarioMock);

        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            guardian.ubicarEn(casilleroMock);

            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> guardian.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}
