package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MapaTest {

    @Test
    public void Test01CreoUnMapaYTiene10x10Casillas() {
        //arrange
        int alto = 10;
        int ancho = 10;
        Mapa mapa = new Mapa(alto, ancho);

        //act
        boolean todoEnRango = true;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (!mapa.enRango(i, j)) {
                    todoEnRango = false;
                }
            }
        }

        //assert
        assertTrue(todoEnRango);

    }

    @Test
    public void Test02CreoUnMapaYTiene10x100Casillas() {
        //arrange
        int alto = 10;
        int ancho = 100;
        Mapa mapa = new Mapa(alto, ancho);

        //act
        boolean todoEnRango = true;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if (!mapa.enRango(i, j)) {
                    todoEnRango = false;
                }
            }
        }
        //assert
        assertTrue(todoEnRango);
    }


    @Test
    public void Test03CambioElTipoDeCasilleroANodoMineral() {

        //Arrange
        Mapa mapa = new Mapa(5, 5);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);

        //Act
        mapa.cambiarTipoCasilla(0, 0, new NodoMineral());
        Casillero casilleroObtenido = mapa.obtenerCasillero(0, 0);

        //Assert
        assertDoesNotThrow(()-> NexoMineral.construir(casilleroObtenido,inventarioMock));
    }
    @Test
    public void Test04CreoUnMapaYReciboLosAdyacentesCorrectosAUnaPosicion() {


        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 0;
        int posy = 0;

        //act
        List<Casillero> adyacentes = mapa.CasillerosAdyacentes(posx, posy);

        //Assert
        assertEquals(2, adyacentes.size());
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy + 1)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx + 1, posy)));
    }


    @Test
    public void Test05CreoUnMapaYReciboLosAdyacentesAUnaPosicionConRango2() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 0;
        int posy = 0;
        int rango = 2;
        //act
        List<Casillero> adyacentes = mapa.casillerosEnRango(posx, posy, rango);

        //Assert
        assertEquals(6, adyacentes.size());
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx + 1, posy)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx + 2, posy)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy + 1)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy + 2)));
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx + 1, posy + 1)));
    }

    @Test
    public void Test06CreoUnMapaYReciboLosAdyacentesAUnaPosicionConRango1() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 4;
        int posy = 5;

        //act
        List<Casillero> adyacentes = mapa.casillerosEnRango(posx, posy, 1);

        //Assert
        assertEquals(5, adyacentes.size());
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy))); //4,4
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx + 1, posy))); //5,5
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx - 1, posy))); //3,5
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy + 1))); //4,6
        assertTrue(adyacentes.contains(mapa.obtenerCasillero(posx, posy - 1))); //4,4
    }

    @Test
    public void Test07ObtenerCasilleroDaElcorrecto() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 4;
        int posy = 5;

        //act
        Casillero casillero = mapa.obtenerCasillero(posx, posy);

        //Assert
        assertEquals(4, casillero.posicionX());
        assertEquals(5, casillero.posicionY());
    }

    @Test
    public void Test08CreoUnMapaYEnergizoCasillasEnRango1() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 4;
        int posy = 5;
        int rango = 1;

        //act
        mapa.energizar(posx, posy, rango);

        //Assert
        assertTrue(mapa.obtenerCasillero(posx, posy).tieneEnergia()); //4,4
        assertTrue(mapa.obtenerCasillero(posx + 1, posy).tieneEnergia()); //5,5
        assertTrue(mapa.obtenerCasillero(posx - 1, posy).tieneEnergia()); //3,5
        assertTrue(mapa.obtenerCasillero(posx, posy + 1).tieneEnergia()); //4,6
        assertTrue(mapa.obtenerCasillero(posx, posy - 1).tieneEnergia()); //4,4
    }

    @Test
    public void Test09CreoUnMapaYDesnergizoCasillasEnRango1() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        int posx = 4;
        int posy = 5;
        int rango = 1;

        //act
        mapa.energizar(posx, posy, rango);
        mapa.desenergizar(posx, posy, rango);

        //Assert
        assertFalse(mapa.obtenerCasillero(posx, posy).tieneEnergia()); //4,4
        assertFalse(mapa.obtenerCasillero(posx + 1, posy).tieneEnergia()); //5,5
        assertFalse(mapa.obtenerCasillero(posx - 1, posy).tieneEnergia()); //3,5
        assertFalse(mapa.obtenerCasillero(posx, posy + 1).tieneEnergia()); //4,6
        assertFalse(mapa.obtenerCasillero(posx, posy - 1).tieneEnergia()); //4,4
    }

    @Test
    public void Test10CreoUnMapaYPasoTurnoYElMohoSeExpande() {
        //Arrange
        Mapa mapa = new Mapa(10, 10);
        mapa.cambiarTipoCasilla(0, 0, new Moho());
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);

        //act
        mapa.pasarTurno();

        //
        assertDoesNotThrow(()-> Criadero.construir((mapa.obtenerCasillero(0,1)),inventarioMock));
        assertDoesNotThrow(()-> Criadero.construir((mapa.obtenerCasillero(1,0)),inventarioMock));
        assertDoesNotThrow(()-> Criadero.construir((mapa.obtenerCasillero(0,0)),inventarioMock));
    }
    }


