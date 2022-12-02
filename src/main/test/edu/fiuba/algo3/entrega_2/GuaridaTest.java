package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.Guarida;
import edu.fiuba.algo3.modelo.unidades.moviles.Larva;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GuaridaTest {
    @Test
    public void test01GuaridaEngendraHidraliscoYDespuesDe4TurnosEstaListo(){
        //ARRANGE
        
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
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
    }

    @Test
    public void test02GuaridaEngendraHidraliscoYDespuesDe3TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        guarida.engendrarHidralisco(larva, inventarioMock);
        for (int i = 0; i < 3; i++) {
            guarida.pasarTurno();
        }
        Unidad hidralisco = guarida.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> hidralisco.recibirDanio(danio));
    }

    @Test
    public void test03GuaridaEngendraHidraliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        Guarida guarida = new Guarida(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> guarida.engendrarHidralisco(larva, inventarioVacio));
    }

    @Test
    public void test04GuaridaEngendraHidraliscoPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        guarida.engendrarHidralisco(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> guarida.engendrarHidralisco(larva, inventarioMock));
    }
}
