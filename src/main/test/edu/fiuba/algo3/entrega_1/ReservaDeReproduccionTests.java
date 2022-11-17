package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservaDeReproduccionTests {

    @Test
    public void test01ConstruyoUnaRerservaDeReproduccionQueEstaraListoEn12Turnos() {

        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Unidad reserva = ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 12; i++) {
                reserva.pasarTurno();
            }
            //ASSERT
                assertDoesNotThrow(() -> reserva.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnaReservaDeReproduccionQueNoSePuedeUsarPasados11Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Unidad reserva = ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 11; i++) {
                reserva.pasarTurno();
            }
            reserva.recibirDanio(5);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> reserva.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoPuedoConstruirUnaReservaDeReproduccionSinLosRecursos(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> ReservaDeReproduccion.construir(casilleroMock, inventarioMock));
    }

    @Test
    public void test04ReservaDeReproduccionEngendraZerlingYDespuesDe2TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        for (int i = 0; i < 2; i++) {
            reservaDeReproduccion.pasarTurno();
        }
        Unidad zerling = reservaDeReproduccion.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> zerling.recibirDanio(5));
    }

    @Test
    public void test05ReservaDeReproduccionEngendraZerlingYDespuesDe1TurnoNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        reservaDeReproduccion.pasarTurno();
        Unidad zerling = reservaDeReproduccion.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> zerling.recibirDanio(5));
    }

    @Test
    public void test06ReservaDeReproduccionEngendraZerlingPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> reservaDeReproduccion.engendrarZerling(larva, inventarioVacio));
    }

    @Test
    public void test07ReservaDeReproduccionEngendraZerlingPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        reservaDeReproduccion.engendrarZerling(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> reservaDeReproduccion.engendrarZerling(larva, inventarioMock));
    }
}