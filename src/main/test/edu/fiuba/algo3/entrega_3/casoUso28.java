package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.moviles.Zealot;
import edu.fiuba.algo3.modelo.unidades.moviles.Zerling;
import org.junit.jupiter.api.Test;

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

        Casillero casilleroMockZealot = mock(Casillero.class);
        when(casilleroMockZealot.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Criadero cria1 = new Criadero(casilleroMock, inventarioMock);
        Criadero cria2 = new Criadero(casilleroMock, inventarioMock);
        Criadero cria3 = new Criadero(casilleroMock, inventarioMock);

        Zealot zealot = new Zealot(inventarioMock);
        Zerling zerling = new Zerling(inventarioMock);
        zerling.ubicarEn(casilleroMock);
        zealot.ubicarEn(casilleroMockZealot);

        //ACT
        for (int i = 0; i < 63; i++) {
            zealot.atacar(cria1);
            zealot.pasarTurno();
            zealot.atacar(cria2);
            zealot.pasarTurno();
            zealot.atacar(cria3);
            zealot.pasarTurno();
        }
        zealot.pasarTurno();

        //ASSERT
        for (int i = 0; i < 42; i++) {
            zerling.atacar(zealot);
            zerling.pasarTurno();
        }
        verify(casilleroMockZealot, times(0)).desocupar();
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
            zealot.pasarTurno();
            zealot.atacar(cria2);
            zealot.pasarTurno();
            zealot.atacar(cria3);
            zealot.pasarTurno();
        }

        zealot.pasarTurno();

        //ASSERT
        try{
            for (int i = 0; i < 40; i++) {
                zerling.atacar(zealot);
                zerling.pasarTurno();
            }
        } catch (Exception e){}

        verify(casilleroMock, times(1)).desocupar();

    }


}
