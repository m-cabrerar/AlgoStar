package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.CasilleroVacio;
import edu.fiuba.algo3.modelo.casillero.NodoMineral;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class NexoMineralTest {
    @Test
    public void test01NexoMineralSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        // Act & Assert
        assertDoesNotThrow(() -> NexoMineral.construir(casillero, mockedInventario));
    }

    @Test
    public void test02NexoMineralSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> NexoMineral.construir(casillero, mockedInventario));
    }

    @Test
    public void test03NexoMineralSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new CasilleroVacio());
        Inventario inventario = new Inventario();
        inventario.agregarGas(300);
        inventario.agregarMineral(300);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> NexoMineral.construir(casillero, inventario));
    }

    @Test
    public void test04ConstruyoUnNexoMineralQueEstaraListoEn4Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,1);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 4; i++) {
            nexoMineral.pasarTurno();
        }
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> nexoMineral.recibirDanio(danio));
    }

    @Test
    public void test05ConstruyoUnNexoMineralYNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        Danio danio = new Danio(0,1);
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> nexoMineral.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnNexoMineralYLuegoDe3turnosNoEstaListo() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);
        Unidad nexoMineral = NexoMineral.construir(mockedCasillero, mockedInventario);
        Danio danio = new Danio(0,1);
        for (int i = 0; i < 3; i++) {
            nexoMineral.pasarTurno();
        }
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> nexoMineral.recibirDanio(danio));
    }

    @Test
    public void test07NexoMineralRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Unidad nexoMineral = new NexoMineral(mockedCasillero, mockedInventario);
        Danio danio = new Danio(0,50);
        Danio danio2 = new Danio(0,499);
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){}
        for (int i = 0; i < 500; i++) {
            nexoMineral.pasarTurno();
        }
        try{nexoMineral.recibirDanio(danio2);}
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
        Danio danio = new Danio(0,300);
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){fail();}
        for (int i = 0; i < 250; i++) {
            nexoMineral.pasarTurno();
        }
        try {
            nexoMineral.recibirDanio(danio);
            assertThrows(EstaDestruido.class, () -> nexoMineral.recibirDanio(danio));
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void test09NexoMineralRecibeDanioYSeDestruye() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Danio danio = new Danio(0,500);
        Inventario inventario = new Inventario();
        inventario.agregarGas(1000);
        inventario.agregarMineral(1000);

        EdificioEnConstruccion nexoMineral = NexoMineral.construir(casillero, inventario);
        // Act
        try{nexoMineral.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test10NexoMineralExtraeMineral() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        NexoMineral nexoMineral = new NexoMineral(casillero, mockedInventario);
        // Act
        int cantidadMineral = nexoMineral.extraerMineral();
        // Assert
        assertEquals(20, cantidadMineral);
    }
}
