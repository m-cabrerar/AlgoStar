package edu.fiuba.algo3.entrega_1;

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
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Edificio reserva = ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
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
        String mensaje = "El edificio esta destruido";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Edificio reserva = ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 11; i++) {
                reserva.pasarTurno();
            }
            reserva.recibirDanio(5);
            Exception exception = assertThrows(Exception.class, () -> {
                reserva.recibirDanio(5);
            });
            //ASSERT
            assertEquals(mensaje, exception.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoPuedoConstruirUnaReservaDeReproduccionSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}