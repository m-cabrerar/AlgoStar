package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.UnidadInvisible;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        Zealot zealot = new Zealot(inventarioMock);
        Zerling zerling = new Zerling(inventarioMock);
        zerling.ubicarEn(casilleroMock);

        //ACT
        zealot.volverseInvisible();

        //ASSERT
        assertThrows(UnidadInvisible.class, () -> zerling.atacar(zealot));
    }

    /*@Test
    public void Test02UnaUnidadEnemigaPuedeAtacarAUnZealotInvisibleSiUnZealotEnSuRangoLoCubre(){

        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Zealot zealot = new Zealot(inventarioMock);
        AmoSupremo amo = new AmoSupremo(inventarioMock);
        amo.ubicarEn(casilleroMock);

        //ACT
        zealot.volverseInvisible();
        amo.atacar(zealot);

        //ASSERT

    }*/


}
