package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EspiralTests {

    @Test
    public void test01ConstruyoUnEspiralQueEstaraListoEn10Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        try {
            Edificio espiral = new Espiral(casilleroMock, inventarioMock);

            //ACT
            for(int i=0; i<10; i++){
                espiral.pasarTurno();
            }
            //ASSERT
            assertDoesNotThrow(() -> espiral.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnEspiralQueNoSePuedeUsarPasados9Turnos() {
        //ARRANGE
        String mensaje = "El edificio esta destruido";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneGuarida()).thenReturn(true);
        try{
            Edificio espiral = Espiral.construir(casilleroMock, inventarioMock);
            //ACT
            for(int i=0; i<9; i++){
                espiral.pasarTurno();
            }
            Exception exception = assertThrows(Exception.class, () -> {
                espiral.recibirDanio(5);
            });
            //ASSERT
            assertEquals(mensaje, exception.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoSePuedeConstruirUnEspiralSinTenerUnaGuarida(){
        //ARRANGE
        String mensaje = "Aun no se puede construir este edificio";
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneGuarida()).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04SePuedeConstruirUnEspiralSiTengoUnaGuarida(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        try{
            //ACT
            when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
            when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
            when(inventarioMock.tieneGuarida()).thenReturn(true);
            //ASSERT
            assertDoesNotThrow(() -> Espiral.construir(casilleroMock, inventarioMock));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test05NoPuedoConstruirUnEspiralSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.sonDelMismoTipoDeCasillero(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
