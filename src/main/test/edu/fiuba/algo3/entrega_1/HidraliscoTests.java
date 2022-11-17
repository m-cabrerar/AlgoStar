package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class HidraliscoTests {
    @Test
    public void test01HidraliscoAtacaAUnidadVoladorYLeHace10DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Hidralisco hidralisco = new Hidralisco(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            hidralisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(10,10);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02HidraliscoAtacaAUnidadTerrestreYLeHace10DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Hidralisco hidralisco = new Hidralisco(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            hidralisco.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(10,10);
        } catch (Exception e) {
            fail();
        }
    }
}
