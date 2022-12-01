package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccesoTest {
    @Test
    public void test01AccesoSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertDoesNotThrow(() -> Acceso.construir(casillero, mockedInventario));
    }

    @Test
    public void test02AccesoSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(false);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Acceso.construir(casillero, mockedInventario));
    }

    @Test
    public void test03AccesoSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Acceso.construir(casillero, mockedInventario));
    }

    @Test
    public void test04ConstruyoUnAccesoQueEstaraListoEn8Turnos() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Danio mockedDanio = mock(Danio.class);
        when(mockedDanio.ataqueTerrestre()).thenReturn(1);

        Unidad acceso = Acceso.construir(casillero, mockedInventario);
        
        for (int i = 0; i < 8; i++) {
            acceso.pasarTurno();
        }
        // Act
        try{acceso.recibirDanio(mockedDanio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> acceso.recibirDanio(mockedDanio));
    }

    @Test
    public void test05ConstruyoUnAccesoYNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Danio danio = new Danio(0,1);

        Unidad acceso = Acceso.construir(casillero, mockedInventario);

        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> acceso.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnAccesoYLuegoDe7turnosNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        
        Danio danio = new Danio(0,1);

        Unidad acceso = Acceso.construir(casillero, mockedInventario);
        for (int i = 0; i < 7; i++) {
            acceso.pasarTurno();
        }
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> acceso.recibirDanio(danio));
    }

    @Test
    public void test07AccesoRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario mockedInventario = mock(Inventario.class);
        
        Danio danio = new Danio(0,50);
        Danio danio2 = new Danio(0,999);

        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);

        Unidad acceso = new Acceso(casillero, mockedInventario);
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        try{acceso.recibirDanio(danio2);}
        catch(Exception e){}
        //ASSERT
        assertDoesNotThrow(()-> casillero.desocupar());
    }

    @Test
    public void test08AccesoRecibeDanioPerdiendoTodoElEscudoYRecuperaSoloEscudo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        
        Danio danio = new Danio(0,550);
        Danio danio2 = new Danio(0,950);

        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
    
        Unidad acceso = new Acceso(casillero, mockedInventario);
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        for(int i=0; i<55; i++){
            acceso.pasarTurno();
        }
        try{acceso.recibirDanio(danio2);}
        catch(Exception e){
        }
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test09AccesoRecibeDanioYSeDestruye() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Danio danio = new Danio(0,1200);

        Unidad acceso = new Acceso(casillero, mockedInventario);
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }
}

