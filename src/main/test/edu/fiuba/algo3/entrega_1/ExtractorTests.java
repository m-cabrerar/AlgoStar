package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.Moho;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExtractorTests {

    @Test
    public void test01ConstruyoUnExtractorQueEstaraListoEn6Turnos() {

        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        try {
            Unidad extractor = Extractor.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 6; i++) {
                extractor.pasarTurno();
            }
            //ASSERT
            assertDoesNotThrow(() -> extractor.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnExtractorQueNoSePuedeUsarPasados5Turnos() {

        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        try{
            Unidad extractor = Extractor.construir(casilleroMock, inventarioMock);
            //ACT
            for(int i=0; i<5; i++){
                extractor.pasarTurno();
            }
            extractor.recibirDanio(danio);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> extractor.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03ConstruyoUnExtractorSobreElGas(){
        //ARRANGE
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        //ACT
        Extractor.construir(casillero, inventarioMock);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }
    @Test
    public void test04ConstruirUnExtractorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "Ubicacion invalida";
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new Moho());
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor.construir(casillero, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void Test05UnExtractorSinZanganosNoGeneraGas() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        try {
            Extractor extractor = new Extractor(casilleroMock, inventarioMock);
            //ACT
            int gas = extractor.extraerGas();
            //ASSERT
            assertEquals(0, gas);
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void Test06UnExtractorCon1ZanganoSaca10DeGas() {
        //ARRANGE
        int cantidadGasEsperado = 10;
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        try{
            Extractor extractor = new Extractor(casilleroMock, inventarioMock);
            //ACT
            extractor.agregarZangano();
            extractor.extraerGas();
            //ASSERT
            verify(inventarioMock, times(1)).agregarGas(cantidadGasEsperado);
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void Test07UnExtractorCon2ZanganosSaca20DeGas() {
        //ARRANGE
        int cantidadGasEsperado = 20;
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        try {
            Extractor extractor = new Extractor(casilleroMock, inventarioMock);
            //ACT
            extractor.agregarZangano();
            extractor.agregarZangano();
            extractor.extraerGas();
            //ASSERT
            verify(inventarioMock, times(1)).agregarGas(cantidadGasEsperado);
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void Test08UnExtractorCon3ZanganosSaca30DeGas() {
        //ARRANGE
        int cantidadGasEsperado = 30;
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        try {
            Extractor extractor = new Extractor(casilleroMock, inventarioMock);
            //ACT
            extractor.agregarZangano();
            extractor.agregarZangano();
            extractor.agregarZangano();
            extractor.extraerGas();
            //ASSERT
            verify(inventarioMock, times(1)).agregarGas(cantidadGasEsperado);
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void Test09UnExtractorNoPuedeTener4ZanganosTrabajando() {
        //ARRANGE
        String mensaje = "El extractor ya tiene 3\n zanganos trabajando";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        try {
            Extractor extractor = new Extractor(casilleroMock, inventarioMock);
            //ACT
            extractor.agregarZangano();
            extractor.agregarZangano();
            extractor.agregarZangano();
            Exception exception = assertThrows(Exception.class, () -> {
                extractor.agregarZangano(); //esto creo que habria que mandarselo a una metodo del inventario para agregar
            });
            //ASSERT
            assertEquals(mensaje, exception.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test10NoPuedoConstruirUnExtractorSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}