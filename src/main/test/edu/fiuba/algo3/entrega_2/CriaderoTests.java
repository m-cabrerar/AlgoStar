package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.EdificioOcupado;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.moviles.Larva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriaderoTests {
    @Test
    public void test01CriaderoEngendraHidraliscoYDespuesDe4TurnosEstaListo(){
        //ARRANGE

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        criadero.engendrarHidralisco();
        for (int i = 0; i < 4; i++) {
            criadero.pasarTurno();
        }
        //Unidad hidralisco = criadero.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> criadero.engendrarHidralisco());
    }

    @Test
    public void test02CriaderoEngendraHidraliscoYDespuesDe3TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        criadero.engendrarHidralisco();
        for (int i = 0; i < 3; i++) {
            criadero.pasarTurno();
        }
        Unidad hidralisco = criadero.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> hidralisco.recibirDanio(danio));
    }

    @Test
    public void test03CriaderoEngendraHidraliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(inventarioLleno.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> criadero.engendrarHidralisco());
    }
    @Test
    public void test05CriaderoEngendraMutaliscoYDespuesDe7TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        criadero.engendrarMutalisco();
        for (int i = 0; i < 7; i++) {
            criadero.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(() -> criadero.engendrarMutalisco());
    }

    @Test
    public void test06CriaderoEngendraMutaliscoYDespuesDe6TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        criadero.engendrarMutalisco();
        for (int i = 0; i < 6; i++) {
            criadero.pasarTurno();
        }
        Unidad mutalisco = criadero.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> mutalisco.recibirDanio(danio));
    }

    @Test
    public void test07CriaderoEngendraMutaliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> criadero.engendrarMutalisco());
    }

    @Test
    public void test09CriaderoEngendraZerlingYDespuesDe2TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.obtenerAdyacente()).thenReturn(casilleroMock);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        criadero.engendrarZerling();
        for (int i = 0; i < 2; i++) {
            criadero.pasarTurno();
        }
        //Unidad zerling = criadero.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> criadero.engendrarZerling());
    }

    //TODO: excepcion
    @Test
    public void test10CriaderoEngendraZerlingYDespuesDe1TurnoNoEstaListo(){
        //ARRANGE
        Danio danio = new Danio(5,5);
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        criadero.engendrarZerling();
        criadero.pasarTurno();
        Unidad zerling = criadero.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> zerling.recibirDanio(danio));
    }

    @Test
    public void test11CriaderoEngendraZerlingPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);

        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(inventarioLleno.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeCrecerPoblacion(anyInt())).thenReturn(true);
        when(inventarioLleno.puedeConstruir(anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casilleroMock, inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> criadero.engendrarZerling());
    }

}
