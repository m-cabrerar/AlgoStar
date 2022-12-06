package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.Espiral;
import edu.fiuba.algo3.modelo.unidades.edificios.Guarida;
import edu.fiuba.algo3.modelo.unidades.edificios.ReservaDeReproduccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.exceptions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EspiralTests {

    @Test
    public void test01ConstruyoUnEspiralQueEstaraListoEn10Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);
        try {
            Unidad espiral = new Espiral(casilleroMock, inventarioMock);

            //ACT
            for(int i=0; i<10; i++){
                espiral.pasarTurno();
            }
            //ASSERT
            assertDoesNotThrow(() -> espiral.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnEspiralQueNoSePuedeUsarPasados9Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        Danio danio = new Danio(0,5);
        try{
            Unidad espiral = Espiral.construir(casilleroMock, inventarioMock);
            //ACT
            for(int i=0; i<9; i++){
                espiral.pasarTurno();
            }
            espiral.recibirDanio(danio);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> espiral.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoSePuedeConstruirUnEspiralSinTenerUnaGuarida(){
        //ARRANGE
        String mensaje = "Aún no se puede construir este edificio";
        Inventario inventario = new Inventario();
        inventario.agregarGas(200);
        inventario.agregarMineral(150);

        Casillero casilleroMock = mock(Casillero.class);

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral.construir(casilleroMock, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04SePuedeConstruirUnEspiralSiTengoUnaGuarida(){
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(1000);
        inventario.agregarMineral(1000);
        Casillero casilleroMock = mock(Casillero.class);
        Casillero casillero2 = mock(Casillero.class);
        Casillero casillero3 = mock(Casillero.class);

        //ACT
            new ReservaDeReproduccion(casillero3,inventario);
            new Guarida(casillero2,inventario);
        //ASSERT
            assertDoesNotThrow(() -> Espiral.construir(casilleroMock, inventario));

    }
    @Test
    public void test05NoPuedoConstruirUnEspiralSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario = new Inventario();

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral.construir(casilleroMock, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

}
