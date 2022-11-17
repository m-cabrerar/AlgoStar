package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EspiralTest {
    @Test
    public void test06EspiralEngendraMutaliscoYDespuesDe7TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 7; i++) {
            espiral.pasarTurno();
        }
        Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> mutalisco.recibirDanio(5));
    }

    @Test
    public void test07EspiralEngendraMutaliscoYDespuesDe6TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 6; i++) {
            espiral.pasarTurno();
        }
        Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> mutalisco.recibirDanio(5));
    }

    @Test
    public void test08EspiralEngendraMutaliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        Espiral espiral = new Espiral(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> espiral.engendrarMutalisco(larva, inventarioVacio));
    }

    @Test
    public void test09EspiralEngendraMutaliscoPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> espiral.engendrarMutalisco(larva, inventarioMock));
    }
}
