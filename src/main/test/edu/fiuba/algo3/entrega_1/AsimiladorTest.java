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
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> Asimilador.construir(casillero, mockedInventario));
    }

    @Test
    public void test02AsimiladorSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Asimilador.construir(casillero, mockedInventario));
    }

    @Test
    public void test03AsimiladorSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new Moho());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Asimilador.construir(casillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnAsimiladorQueEstaraListoEn6Turnos() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(casillero, mockedInventario);
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
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(casillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(1);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> asimilador.recibirDanio(1));
    }

    @Test
    public void test06ConstruyoUnAsimiladorYLuegoDe5turnosNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(casillero, mockedInventario);
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
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = new Asimilador(casillero, mockedInventario);
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
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test08AsimiladorRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador =  Asimilador.construir(casillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(500);}
        catch(Exception e){}
        for (int i = 0; i < 50; i++) {
            asimilador.pasarTurno();
        }
        try{asimilador.recibirDanio(950);}
        catch(Exception e){}
        // Assert
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test09AsimiladorRecibeDanioYSeDestruye() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad asimilador = Asimilador.construir(casillero, mockedInventario);
        // Act
        try{asimilador.recibirDanio(1000);}
        catch(Exception e){}
        // Assert
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test10AsimiladorExtraeGas() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Asimilador asimilador = new Asimilador(casillero, mockedInventario);
        // Act
        int gasExtraido = asimilador.extraerGas();
        // Assert
        assertEquals(20, gasExtraido);
    }
}
