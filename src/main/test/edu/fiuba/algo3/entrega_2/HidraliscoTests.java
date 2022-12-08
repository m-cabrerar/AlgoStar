package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class HidraliscoTests {
    @Test
    public void test01HidraliscoAtacaAUnidadVoladorYLeHace10DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Hidralisco hidra = new Hidralisco(inventarioMock);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        //ACT
        try {
            hidra.ubicarEn(casilleroMock);
            mutalisco.ubicarEn(casilleroMock);
            for(int i=0; i<12; i++){
                hidra.atacar(mutalisco);
                hidra.pasarTurno();
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    @Test
    public void test02HidraliscoAtacaAUnidadTerrestreYLeHace10DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Hidralisco hidralisco = new Hidralisco(inventarioMock);
        Hidralisco hidra2 = new Hidralisco(inventarioMock);
        //ACT
        try {
            hidralisco.ubicarEn(casilleroMock);
            hidra2.ubicarEn(casilleroMock);
            for(int i=0; i<8; i++){
                hidralisco.atacar(hidra2);
                hidralisco.pasarTurno();
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    public void test03HidraliscoNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Hidralisco hidra = new Hidralisco(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            hidra.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> hidra.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}
