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
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        // Act & Assert
        assertDoesNotThrow(() -> PuertoEstelar.construir(casillero, mockedInventario));
    }

    @Test
    public void test02PuertoEstelarSeConstruyeEnLaCasillaCorrectaYConCorrelativasPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> PuertoEstelar.construir(casillero, mockedInventario));
    }

    @Test
    public void test03PuertoEstelarSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientesYCorrelativas() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> PuertoEstelar.construir(casillero, mockedInventario));
    }

    @Test
    public void test04PuertoEstelarSeConstruyeEnLaCasillaCorrectaYRecursosSuficientesPeroSinCorrelativas() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario inventario = new Inventario();
        inventario.agregarMineral(1000);
        inventario.agregarGas(1000);
        // Act & Assert
        assertThrows(CorrelativasInsuficientes.class, () -> PuertoEstelar.construir(casillero, inventario));
    }

    @Test
    public void test05ConstruyoUnPuertoEstelarQueEstaraListoEn10Turnos() {
        // Arrange
        Danio danio = new Danio(0,1);
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 10; i++) {
            puertoEstelar.pasarTurno();
        }
        // Act
        try{puertoEstelar.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> puertoEstelar.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnPuertoEstelarYNoEstaListo() {
        // Arrange
        Danio danio = new Danio(0,1);
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        // Act
        try{puertoEstelar.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> puertoEstelar.recibirDanio(danio));
    }

    @Test
    public void test07ConstruyoUnPuertoEstelarYLuegoDe9turnosNoEstaListo() {
        // Arrange
        Danio danio = new Danio(0,1);
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad puertoEstelar = PuertoEstelar.construir(mockedCasillero, mockedInventario);
        for (int i = 0; i < 9; i++) {
            puertoEstelar.pasarTurno();
        }
        // Act
        try{puertoEstelar.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> puertoEstelar.recibirDanio(danio));
    }

    @Test
    public void test08PuertoEstelarRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Unidad puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);

        Danio danio = new Danio(0,50);
        Danio danio2 = new Danio(0,1199);
        // Act
        try{puertoEstelar.recibirDanio(danio);}
        catch(Exception e){}
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        try{puertoEstelar.recibirDanio(danio2);}
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
        when(mockedInventario.puedeConstruir(anyInt())).thenReturn(true);

        Danio danio = new Danio(0,650);
        Danio danio2 = new Danio(0,1150);

        Unidad puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);

        // Act
        try{puertoEstelar.recibirDanio(danio);}
        catch(Exception e){}
        for (int i = 0; i < 65; i++) {
            puertoEstelar.pasarTurno();
        }
        try{puertoEstelar.recibirDanio(danio2);}
        catch(Exception e){}
        // Assert
        verify(mockedCasillero, times(0)).desocupar();
    }

    @Test
    public void test10PuertoEstelarRecibeDanioYSeDestruye() {
        // Arrange
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);

        Danio danio = new Danio(0,700);
        Unidad puertoEstelar = new PuertoEstelar(mockedCasillero, mockedInventario);
        // Act
        try{
            puertoEstelar.recibirDanio(danio);

            //Assert
            assertThrows(EstaDestruido.class, () -> puertoEstelar.recibirDanio(danio));
        }
        catch(Exception e){
            fail();
        }
    }
}
