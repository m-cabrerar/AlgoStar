package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CriaderoTests {
    /*Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 y
     *después de 1 turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar
     *que se regeneren acorde a los tiempos estipulados.
     */
    @Test
    public void test01ConsumoLaLarvaDeUnCriaderoParaEngendrarZanganoYCuandoPasaElTurnoTengo3OtraVez() {
        
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casillero = mock(Casillero.class);
        Inventario inventario = mock(Inventario.class);
        Criadero criadero = new Criadero(casillero, inventario);
        //ACT
        try {
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
 
    }

    @Test
    public void test02Consumo2LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan2TurnosTengo3OtraVez() {
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casillero = mock(Casillero.class);
        Inventario inventario = mock(Inventario.class);
        Criadero criadero = new Criadero(casillero, inventario);
        //ACT
        try {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test03Consumo3LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan3TurnosTengo3OtraVez() {
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        try {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04ConstruyoUnCriaderoQueEstaraListoEn4Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Edificio criadero = Criadero.construir(casilleroMock, inventarioMock);
            //ACT
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> criadero.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test05ConstruyoUnCriaderoQueNoSePuedeUsarPasados3Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        try {
            Edificio criadero = Criadero.construir(casilleroMock, inventarioMock);
            //ACT
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.recibirDanio(5);
            //ASSERT
            assertThrows(EstaDestruido.class, () -> criadero.recibirDanio(5));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test06ConstruirUnCriaderoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "Ubicacion invalida";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(false);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test07NoPuedoConstruirUnCriaderoSinLosRecursos(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(casilleroMock.esDelTipo(any())).thenReturn(true);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> Criadero.construir(casilleroMock, inventarioMock));
    }
}