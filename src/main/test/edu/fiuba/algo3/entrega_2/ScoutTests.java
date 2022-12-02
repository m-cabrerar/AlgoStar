package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.moviles.Scout;
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
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        
        Scout scout = new Scout(inventarioMock);
        Mutalisco muta = new Mutalisco(inventarioMock);
        //ACT
        try {
            scout.ubicarEn(casilleroMock);
            muta.ubicarEn(casilleroMock);
            for(int i=0; i<9; i++){
                scout.atacar(muta);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }

    @Test
    public void test02ScoutAtacaAUnidadTerrestreYLeHace8DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Scout scout = new Scout(inventarioMock);
        Hidralisco hidra = new Hidralisco(inventarioMock);
        //ACT
        try {
            scout.ubicarEn(casilleroMock);
            hidra.ubicarEn(casilleroMock);
            for(int i=0; i<10; i++){
                scout.atacar(hidra);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT
        verify(casilleroMock, times(1)).desocupar();
    }
}
