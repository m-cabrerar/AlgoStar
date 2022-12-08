package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.edificios.Guarida;
import edu.fiuba.algo3.modelo.unidades.edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuaridaTests {

    @Test
    public void test01ConstruyoUnaGuaridaQueEstaraListoEn12Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        try {
            Unidad guarida = Guarida.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 12; i++) {
                guarida.pasarTurno();
            }
            //ASSERT
            assertDoesNotThrow(() -> guarida.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test02ConstruyoUnaGuaridaQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);
        try {
            Unidad guarida = Guarida.construir(casilleroMock, inventarioMock);
            //ACT
            for (int i = 0; i < 11; i++) {
                guarida.pasarTurno();
            }
            guarida.recibirDanio(danio);
            // ASSERT
            assertThrows(EstaDestruido.class, () -> guarida.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test03NoSePuedeConstruirUnaGuaridaSinTenerUnaReservaDeReproduccion(){
        //ARRANGE
        String mensaje = "Aún no se puede \nconstruir este edificio";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario = new Inventario();
        inventario.agregarMineral(1000);
        inventario.agregarGas(1000);

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida.construir(casilleroMock, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04SePuedeConstruirUnaGuaridaSiTengoUnaReservaDeReproduccion(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Casillero casillero= mock(Casillero.class);

        Inventario inventario = new Inventario();
        inventario.agregarGas(1000);
        inventario.agregarMineral(1000);
        //ACT
        try {

            ReservaDeReproduccion reserva = new ReservaDeReproduccion(casillero, inventario);
            reserva.ubicarEnInventario();
            //ASSERT
            Guarida.construir(casilleroMock, inventario);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test05NoPuedoConstruirUnaGuaridaSinLosRecursos(){
        //ARRANGE
        String mensaje = "No tiene recursos";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        when(inventarioMock.tieneRecursos(anyInt(),anyInt())).thenReturn(false);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida.construir(casilleroMock, inventarioMock);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }


}
