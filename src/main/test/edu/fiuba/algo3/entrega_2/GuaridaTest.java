/*
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GuaridaTest {
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
        Unidad hidralisco = guarida.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> hidralisco.recibirDanio(5));
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

 */
