package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaDeReproduccionTest {
    @Test
    public void test01ReservaDeReproduccionEngendraZerlingYDespuesDe2TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        for (int i = 0; i < 2; i++) {
            reservaDeReproduccion.pasarTurno();
        }
        //Unidad zerling = reservaDeReproduccion.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> reservaDeReproduccion.engendrarZerling(larva, inventarioMock));
    }

    //TODO: excepcion
    @Test
    public void test02ReservaDeReproduccionEngendraZerlingYDespuesDe1TurnoNoEstaListo(){
        //ARRANGE
        Danio danio = new Danio(5,5);
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        reservaDeReproduccion.pasarTurno();
        Unidad zerling = reservaDeReproduccion.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> zerling.recibirDanio(danio));
    }

    @Test
    public void test03ReservaDeReproduccionEngendraZerlingPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> reservaDeReproduccion.engendrarZerling(larva, inventarioVacio));
    }

    @Test
    public void test04ReservaDeReproduccionEngendraZerlingPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> reservaDeReproduccion.engendrarZerling(larva, inventarioMock));
    }
}
