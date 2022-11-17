package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
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
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(true);
        try {
            Unidad guarida = Guarida.construir(casilleroMock, inventarioMock);
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
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneReservaDeReproduccion()).thenReturn(true);
        try {
            Unidad guarida = Guarida.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 11; i++) {
                guarida.pasarTurno();
            }
            guarida.recibirDanio(5);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> guarida.recibirDanio(5));
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
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
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
            when(casilleroMock.esDelTipo(any())).thenReturn(true);
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
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test06GuaridaEngendraHidraliscoYDespuesDe4TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        guarida.engendrarHidralisco(larva, inventarioMock);
        for (int i = 0; i < 4; i++) {
            guarida.pasarTurno();
        }
        //Unidad hidralisco = guarida.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> guarida.engendrarHidralisco(larva, inventarioMock));
        //si no estuviera listo el hidralisco anterior esto tiraria error
    }

    @Test
    public void test07GuaridaEngendraHidraliscoYDespuesDe3TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        guarida.engendrarHidralisco(larva, inventarioMock);
        for (int i = 0; i < 3; i++) {
            guarida.pasarTurno();
        }
        Unidad hidralisco = guarida.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> hidralisco.recibirDanio(5));
    }

    @Test
    public void test08GuaridaEngendraHidraliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        Guarida guarida = new Guarida(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> guarida.engendrarHidralisco(larva, inventarioVacio));
    }

    @Test
    public void test09GuaridaEngendraHidraliscoPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        guarida.engendrarHidralisco(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> guarida.engendrarHidralisco(larva, inventarioMock));
    }
}
