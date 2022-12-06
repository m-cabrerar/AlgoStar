package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.Espiral;
import edu.fiuba.algo3.modelo.unidades.moviles.Larva;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EspiralTest {
    @Test
    public void test01EspiralEngendraMutaliscoYDespuesDe7TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 7; i++) {
            espiral.pasarTurno();
        }

        //Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> espiral.engendrarMutalisco(larva, inventarioMock));
    }

    @Test
    public void test02EspiralEngendraMutaliscoYDespuesDe6TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 6; i++) {
            espiral.pasarTurno();
        }
        Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> mutalisco.recibirDanio(danio));
    }

    @Test
    public void test03EspiralEngendraMutaliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        Espiral espiral = new Espiral(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> espiral.engendrarMutalisco(larva, inventarioVacio));
    }

    @Test
    public void test04EspiralEngendraMutaliscoPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> espiral.engendrarMutalisco(larva, inventarioMock));
    }
}
