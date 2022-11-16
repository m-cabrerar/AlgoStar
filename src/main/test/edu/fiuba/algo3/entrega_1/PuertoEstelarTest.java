package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PuertoEstelarTest {
    @Test
    public void test01PuertoEstelarSeConstruyeEnLaCasillaCorrectaConRecursosSuficientesYCorrelativas() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> PuertoEstelar.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test02PuertoEstelarSeConstruyeEnLaCasillaCorrectaYConCorrelativasPeroConRecursosInsuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> PuertoEstelar.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test03PuertoEstelarSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientesYCorrelativas() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(false);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> PuertoEstelar.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test04PuertoEstelarSeConstruyeEnLaCasillaCorrectaYRecursosSuficientesPeroSinCorrelativas() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(false);
        // Act & Assert
        assertThrows(CorrelativasInsuficientes.class, () -> PuertoEstelar.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test05ConstruyoUnPuertoEstelarQueEstaraListoEn10Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 10; i++) {
            puertoEstelar.pasarTurno();
        }
        // Act
        try{puertoEstelar.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> puertoEstelar.recibirDanio(1));
    }

    @Test
    public void test06ConstruyoUnPuertoEstelarYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        // Act
        try{puertoEstelar.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> puertoEstelar.recibirDanio(1));
    }

    @Test
    public void test07ConstruyoUnPuertoEstelarYLuegoDe9turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 9; i++) {
            puertoEstelar.pasarTurno();
        }
        // Act
        try{puertoEstelar.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> puertoEstelar.recibirDanio(1));
    }

    @Test
    public void test08PuertoEstelarRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);
        // Act
        try{puertoEstelar.recibirDanio(50);}
        catch(Exception e){}
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        try{puertoEstelar.recibirDanio(1199);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test09PuertoEstelarRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);
        // Act
        try{puertoEstelar.recibirDanio(650);}
        catch(Exception e){}
        for (int i = 0; i < 65; i++) {
            puertoEstelar.pasarTurno();
        }
        try{puertoEstelar.recibirDanio(1150);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test10PuertoEstelarRecibeDanioYSeDestruye() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneAcceso()).thenReturn(true);
        Edificio puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);
        // Act
        try{puertoEstelar.recibirDanio(1200);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }
}
