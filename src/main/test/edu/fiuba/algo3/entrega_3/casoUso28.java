/*package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.UnidadInvisible;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        zealot.invisibilizar();

        //ASSERT
        assertThrows(UnidadInvisible.class, () -> zerling.atacar(zealot));
    }

    @Test
    public void Test02UnaUnidadEnemigaPuedeAtacarAUnZealotInvisibleSiUnZealotEnSuRangoLoCubre(){

        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(true);
        when(inventarioMock.puedeCrecerPoblacion(anyInt())).thenReturn(true);

        Casillero casilleroMock1 = mock(Casillero.class);
        when(casilleroMock1.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Casillero casilleroMock2 = mock(Casillero.class);
        Casillero casilleroMock3 = mock(Casillero.class);
        when(casilleroMock3.tieneEnRango(any(Unidad.class), anyInt())).thenReturn(true);

        Zealot zealot = new Zealot(inventarioMock);
        Zerling zerling = new Zerling(inventarioMock);
        AmoSupremo amo = new AmoSupremo(inventarioMock);

        List<AmoSupremo> amosEnRango = new ArrayList<>();
        amosEnRango.add(amo);

        when(casilleroMock2.tengoEnRangoAmoSupremo(inventarioMock)).thenReturn(true);
        when(inventarioMock.obtenerAmosSupremos()).thenReturn(amosEnRango);

        //ACT
        amo.ubicarEn(casilleroMock1);

        zealot.ubicarEn(casilleroMock2);
        zealot.invisibilizar();
        zealot.pasarTurno();

        zerling.ubicarEn(casilleroMock3);

        //ASSERT
        assertDoesNotThrow(() -> zerling.atacar(zealot));

    }


}*/
