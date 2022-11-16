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
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Edificio reserva = ReservaDeReproduccion.construir(casilleroMock, inventarioMock);
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
}