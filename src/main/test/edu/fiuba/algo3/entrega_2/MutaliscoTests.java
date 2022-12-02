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

public class MutaliscoTests {
    @Test
    public void test01MutaliscoAtacaAUnidadVoladorYLeHace9DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        Mutalisco muta2 = new Mutalisco(inventarioMock);
        //ACT
        try {
            mutalisco.ubicarEn(casilleroMock);
            muta2.ubicarEn(casilleroMock);
            for(int i=0; i<14; i++){
                mutalisco.atacar(muta2);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    @Test
    public void test02MutaliscoAtacaAUnidadTerrestreYLeHace9DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);;

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        Hidralisco hidra = new Hidralisco(inventarioMock);

        //ACT
        try {
            mutalisco.ubicarEn(casilleroMock);
            hidra.ubicarEn(casilleroMock);
            for(int i=0; i<9; i++){
                mutalisco.atacar(hidra);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    public void test03MutaliscoNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
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
