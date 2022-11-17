/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class DragonTests {

    @Test
    public void test01DragonAtacaAUnidadVoladorYLeHace20DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Dragon dragon = new Dragon(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            dragon.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(20,20);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02DragonAtacaAUnidadTerrestreYLeHace20DeDanio() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Dragon dragon = new Dragon(casilleroMock, inventarioMock);
        Unidad unidadMock = mock(Unidad.class);
        //ACT
        try {
            dragon.atacar(unidadMock);
            //ASSERT
            verify(unidadMock, times(1)).recibirDanio(20,20);
        } catch (Exception e) {
            fail();
        }
    }
}
*/
