package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuaridaTests {

    @Test
    public void test01ConstruyoUnaGuaridaQueEstaraListoEn12Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(true);
        try {
            Edificio guarida = Guarida.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 12; i++) {
                guarida.pasarTurno();
            }
            //ASSERT
            assertDoesNotThrow(() -> guarida.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnaGuaridaQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        String mensaje = "El edificio esta destruido";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(true);
        try {
            Edificio guarida = Guarida.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 11; i++) {
                guarida.pasarTurno();
            }
            guarida.recibirDanio(5);
            Exception exception = assertThrows(Exception.class, () -> {
                guarida.recibirDanio(5);
            });
            //ASSERT
            assertEquals(mensaje, exception.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoSePuedeConstruirUnaGuaridaSinTenerUnaReservaDeReproduccion(){
        //ARRANGE
        String mensaje = "Aun no se puede construir este edificio";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04SePuedeConstruirUnaGuaridaSiTengoUnaReservaDeReproduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        //ACT
        try {
            when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
            when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
            when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(true);
            //ASSERT
            Guarida.construir(casilleroMock, inventarioMock);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test05NoPuedoConstruirUnaGuaridaSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
