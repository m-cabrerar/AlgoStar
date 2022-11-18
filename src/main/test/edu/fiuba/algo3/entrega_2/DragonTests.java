/*
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.AtaqueFueraDeRango;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class DragonTests {

    @Test
    public void test01DragonAtacaAUnidadVoladorYLeHace20DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);

        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Dragon dragon = new Dragon(inventarioMock);
        //ACT
        try {
            dragon.ubicarEn(casilleroMock);
            dragon.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(20);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02DragonAtacaAUnidadTerrestreYLeHace20DeDanio() {
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);

        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(true);

        Dragon dragon = new Dragon(inventarioMock);
        //ACT
        try {
            dragon.ubicarEn(casilleroMock);
            dragon.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(20);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test03NoPuedeAtacarSiNoTieneAlObjetivoEnRango(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);

        UnidadMovil unidadMock = mock(UnidadMovil.class);
        when(unidadMock.esVoladora()).thenReturn(false);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(), anyInt())).thenReturn(false);
        Dragon dragon = new Dragon(inventarioMock);
        //ACT
        try {
            dragon.ubicarEn(casilleroMock);
            //ASSERT
            assertThrows(AtaqueFueraDeRango.class, () -> dragon.atacar(unidadMock));

        } catch (Exception e) {
            fail();
        }

    }
}

 */
