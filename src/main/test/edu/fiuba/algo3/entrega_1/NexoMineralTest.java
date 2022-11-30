package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class NexoMineralTest {
    @Test
    public void test01NexoMineralSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> NexoMineral.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test02NexoMineralSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> NexoMineral.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test03NexoMineralSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> NexoMineral.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnNexoMineralQueEstaraListoEn4Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 4; i++) {
            nexoMineral.pasarTurno();
        }
        // Act
        try{nexoMineral.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> nexoMineral.recibirDanio(1));
    }

    @Test
    public void test05ConstruyoUnNexoMineralYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        // Act
        try{nexoMineral.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> nexoMineral.recibirDanio(1));
    }

    @Test
    public void test06ConstruyoUnNexoMineralYLuegoDe3turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 3; i++) {
            nexoMineral.pasarTurno();
        }
        // Act
        try{nexoMineral.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> nexoMineral.recibirDanio(1));
    }

    @Test
    public void test07NexoMineralRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = new NexoMineral(mockedCasillero, mockedInventario);
        // Act
        try{nexoMineral.recibirDanio(50);}
        catch(Exception e){}
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        try{nexoMineral.recibirDanio(499);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test08NexoMineralRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = new NexoMineral(mockedCasillero, mockedInventario);
        // Act
        try{nexoMineral.recibirDanio(300);}
        catch(Exception e){}
        for (int i = 0; i < 50; i++) {
            nexoMineral.pasarTurno();
        }
        try{nexoMineral.recibirDanio(450);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test09NexoMineralRecibeDanioYSeDestruye() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = new NexoMineral(mockedCasillero, mockedInventario);
        // Act
        try{nexoMineral.recibirDanio(500);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test10NexoMineralExtraeMineral() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.extraerMineral(20)).thenReturn(20);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        NexoMineral nexoMineral = new NexoMineral(mockedCasillero, mockedInventario);
        // Act
        int cantidadMineral = nexoMineral.extraerMineral(mockedInventario);
        // Assert
        assertEquals(20, cantidadMineral);
    }
}
