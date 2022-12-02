package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.UnidadInvisible;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class casoUso28 {

    //Verificar que unidades enemigas no pueden atacar al zealot estando invisible y sí puedan hacerlo cuando un zealot en su rango lo cubre.

    @Test
    public void Test01UnaUnidadEnemigaNoPuedeAtacarAUnZealotInvisible(){

        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Criadero cria1 = new Criadero(casilleroMock, inventarioMock);
        Criadero cria2 = new Criadero(casilleroMock, inventarioMock);
        Criadero cria3 = new Criadero(casilleroMock, inventarioMock);

        Zealot zealot = new Zealot(inventarioMock);
        Zerling zerling = new Zerling(inventarioMock);
        zerling.ubicarEn(casilleroMock);

        //ACT
        for (int i = 0; i < 63; i++) {
            zealot.atacar(cria1);
            zealot.atacar(cria2);
            zealot.atacar(cria3);
        }

        //ASSERT
        for (int i = 0; i < 42; i++) {
            zerling.atacar(zealot);
        }
        verify(casilleroMock, times(0)).desocupar();
    }

    @Test
    public void Test02UnaUnidadEnemigaPuedeAtacarAUnZealotInvisibleSiUnZealotEnSuRangoLoCubre(){

        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);
        when(casilleroMock.casilleroQuitaInvisibilidad()).thenReturn(true);

        Casillero casilleroMock1 = mock(Casillero.class);
        when(casilleroMock1.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Zealot zealot = new Zealot(inventarioMock);
        Zerling zerling = new Zerling(inventarioMock);

        //ACT
        zerling.ubicarEn(casilleroMock1);
        zealot.ubicarEn(casilleroMock);

        Criadero cria1 = new Criadero(casilleroMock1, inventarioMock);
        Criadero cria2 = new Criadero(casilleroMock1, inventarioMock);
        Criadero cria3 = new Criadero(casilleroMock1, inventarioMock);
        for (int i = 0; i < 63; i++) {
            zealot.atacar(cria1);
            zealot.atacar(cria2);
            zealot.atacar(cria3);
        }

        zealot.pasarTurno();

        //ASSERT
        try{
            for (int i = 0; i < 40; i++) {
                zerling.atacar(zealot);
            }
        } catch (Exception e){}

        verify(casilleroMock, times(1)).desocupar();

    }


}
