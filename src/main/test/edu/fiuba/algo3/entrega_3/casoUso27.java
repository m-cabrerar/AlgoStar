package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class casoUso27 {
    /* Verificar el comportamiento y condiciones de evolucion del Devorador*/
    @Test
    public void Test01NoSePuedeEvolucionarDevoradorSinRecursosSuficientes(){
        //ARRANGE
        Inventario inventarioLleno = mock(Inventario.class);
        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Inventario inventarioVacio = mock(Inventario.class);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(inventarioVacio.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioVacio.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        Mutalisco mutalisco = new Mutalisco(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> mutalisco.evolucionarADevorador(inventarioVacio));
    }

    @Test
    public void Test02SePuedeEvolucionarDevoradorConRecursosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Casillero casilleroMock = mock(Casillero.class);
        Mutalisco mutalisco = new Mutalisco(inventarioMock);
        mutalisco.ubicarEn(casilleroMock);
        //ACT & ASSERT
        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador(inventarioMock));
    }
}
