package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;
import edu.fiuba.algo3.modelo.unidades.moviles.Zealot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZealotTests {
    @Test
    public void test01ZealotAtacaAUnidadVoladorYNoLeHaceDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Zealot zealot = new Zealot(inventarioMock);
        Mutalisco muta = new Mutalisco(inventarioMock);
        //ACT
        try {
            zealot.ubicarEn(casilleroMock);
            muta.ubicarEn(casilleroMock);
            for(int i=0; i<30; i++){
                zealot.atacar(muta);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(0)).desocupar();
    }

    @Test
    public void test02ZealotAtacaAUnidadTerrestreYLeHace8DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Zealot zealot = new Zealot(inventarioMock);
        Hidralisco hidra = new Hidralisco(inventarioMock);
        //ACT
        try {
            zealot.ubicarEn(casilleroMock);
            hidra.ubicarEn(casilleroMock);
            for(int i=0; i<10; i++){
                zealot.atacar(hidra);
            }
        } catch (Exception e) {
            fail();
        }
        //ASSERT 
        verify(casilleroMock, times(1)).desocupar();
    }
    public void test03ZealotNoPuedeAtacarAUnaUnidadFueraDeRango() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);
        Zealot zealot = new Zealot(inventarioMock);
        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);
        //ACT
        try {
            zealot.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> zealot.atacar(unidadMock));
        } catch (Exception e) {
            fail();
        }
    }
}
