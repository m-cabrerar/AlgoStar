package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import edu.fiuba.algo3.modelo.unidades.Unidad;
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
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

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
        Inventario inventario = new Inventario();
        inventario.agregarGas(300);
        inventario.agregarMineral(300);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Pilon.construir(casillero, inventario));
    }

    @Test
    public void test04ConstruyoUnPilonQueEstaraListoEn5Turnos() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        Danio danio = new Danio(0,1);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

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
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

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
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

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
        for (int i = 0; i < 500; i++) {
            pilon.pasarTurno();
        }
        try{pilon.recibirDanio(danio2);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test08PilonRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Danio danio = new Danio(0,350);
        Danio danio2 = new Danio(0,549);
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Pilon pilon = new Pilon(mockedCasillero, mockedInventario);
        // Act
        try{pilon.recibirDanio(danio);}
        catch(Exception e){}
        for (int i = 0; i < 500; i++) {
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
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad pilon = new Pilon(casillero, mockedInventario);
        // Act
        try{
            pilon.recibirDanio(danio);
            fail();
        } catch (EstaDestruido e){
            assertFalse(casillero.estaOcupado());
        }
    }

}
