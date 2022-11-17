package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PilonTest {
    @Test
    public void test01PilonSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> Pilon.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test02PilonSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Pilon.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test03PilonSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(false);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Pilon.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnPilonQueEstaraListoEn5Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 5; i++) {
            pilon.pasarTurno();
        }
        // Act
        try{pilon.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> pilon.recibirDanio(1));
    }

    @Test
    public void test05ConstruyoUnPilonYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> pilon.recibirDanio(1));
    }

    @Test
    public void test06ConstruyoUnPilonYLuegoDe4turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 4; i++) {
            pilon.pasarTurno();
        }
        // Act
        try{pilon.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> pilon.recibirDanio(1));
    }

    @Test
    public void test07PilonRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(50);}
        catch(Exception e){}
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        try{pilon.recibirDanio(599);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test08PilonRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(350);}
        catch(Exception e){}
        for (int i = 0; i < 35; i++) {
            pilon.pasarTurno();
        }
        try{pilon.recibirDanio(550);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test09PilonRecibeDanioYSeDestruye() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(600);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

}
