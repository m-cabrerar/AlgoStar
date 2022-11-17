package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.exceptions.*;
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
            Unidad espiral = new Espiral(casilleroMock, inventarioMock);

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
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneGuarida()).thenReturn(true);
        try{
            Unidad espiral = Espiral.construir(casilleroMock, inventarioMock);
            //ACT
            for(int i=0; i<9; i++){
                espiral.pasarTurno();
            }
            espiral.recibirDanio(5);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> espiral.recibirDanio(5));
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
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
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
            when(casilleroMock.esDelTipo(any())).thenReturn(true);
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
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test06EspiralEngendraMutaliscoYDespuesDe7TurnosEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 7; i++) {
            espiral.pasarTurno();
        }
        //Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertDoesNotThrow(() -> espiral.engendrarMutalisco(larva, inventarioMock));
        //si no estuviera listo el mutalisco anterior esto tiraria error
    }

    @Test
    public void test07EspiralEngendraMutaliscoYDespuesDe6TurnosNoEstaListo(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        for (int i = 0; i < 6; i++) {
            espiral.pasarTurno();
        }
        Unidad mutalisco = espiral.obtenerUnidad();
        //ASSERT
        assertThrows(NullPointerException.class, () -> mutalisco.recibirDanio(5));
    }

    @Test
    public void test08EspiralEngendraMutaliscoPeroNoHayMaterialesSuficientes(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioLleno = mock(Inventario.class);
        Inventario inventarioVacio = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioLleno.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioVacio.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        Espiral espiral = new Espiral(casilleroMock, inventarioLleno);
        Larva larva = new Larva(inventarioLleno);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> espiral.engendrarMutalisco(larva, inventarioVacio));
    }

    @Test
    public void test09EspiralEngendraMutaliscoPeroYaHayUnaUnidadEnProduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Larva larva = new Larva(inventarioMock);
        //ACT
        espiral.engendrarMutalisco(larva, inventarioMock);
        //ASSERT
        assertThrows(EdificioOcupado.class, () -> espiral.engendrarMutalisco(larva, inventarioMock));
    }
}
