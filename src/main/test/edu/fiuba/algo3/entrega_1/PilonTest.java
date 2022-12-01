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
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> Pilon.construir(casillero, mockedInventario));
    }

    @Test
    public void test02PilonSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Pilon.construir(casillero, mockedInventario));
    }

    @Test
    public void test03PilonSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Pilon.construir(casillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnPilonQueEstaraListoEn5Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,1);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 5; i++) {
            pilon.pasarTurno();
        }
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> pilon.recibirDanio(danio));
    }

    @Test
    public void test05ConstruyoUnPilonYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,1);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> pilon.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnPilonYLuegoDe4turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,1);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = Pilon.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 4; i++) {
            pilon.pasarTurno();
        }
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> pilon.recibirDanio(danio));
    }

    @Test
    public void test07PilonRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,50);
        Danio danio2 = new Danio(0,599);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        try{pilon.recibirDanio(danio2);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test08PilonRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Danio danio = new Danio(0,350);
        Danio danio2 = new Danio(0,550);
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Pilon pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        for (int i = 0; i < 35; i++) {
            pilon.pasarTurno();
        }
        try{pilon.recibirDanio(danio2);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test09PilonRecibeDanioYSeDestruye() {
        // Arrange
        Danio danio = new Danio(0,600);
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad pilon = new Pilon(casillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertFalse(casillero.estaOcupado());
    }

}
