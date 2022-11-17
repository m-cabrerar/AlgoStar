package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AsimiladorTest {
    @Test
    public void test01AsimiladorSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> Asimilador.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test02AsimiladorSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Asimilador.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test03AsimiladorSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(false);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Asimilador.construir(mockedCasillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnAsimiladorQueEstaraListoEn6Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 6; i++) {
            asimilador.pasarTurno();
        }
        // Act
        try{asimilador.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> asimilador.recibirDanio(1));
    }

    @Test
    public void test05ConstruyoUnAsimiladorYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(mockedCasillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> asimilador.recibirDanio(1));
    }

    @Test
    public void test06ConstruyoUnAsimiladorYLuegoDe5turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 5; i++) {
            asimilador.pasarTurno();
        }
        // Act
        try{asimilador.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> asimilador.recibirDanio(1));
    }

    @Test
    public void test07AsimiladorRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = new Asimilador(mockedCasillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(50);}
        catch(Exception e){}
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        try{asimilador.recibirDanio(899);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test08AsimiladorRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = new Asimilador(mockedCasillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(500);}
        catch(Exception e){}
        for (int i = 0; i < 50; i++) {
            asimilador.pasarTurno();
        }
        try{asimilador.recibirDanio(950);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test09AsimiladorRecibeDanioYSeDestruye() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = new Asimilador(mockedCasillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(1000);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(1)).desocupar();
    }

    @Test
    public void test10AsimiladorExtraeGas() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        when(mockedCasillero.extraerGas(20)).thenReturn(20);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Asimilador asimilador = new Asimilador(mockedCasillero, mockedInventario);
        // Act
        int gasExtraido = asimilador.extraerGas();
        // Assert
        assertEquals(20, gasExtraido);
    }
}
