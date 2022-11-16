package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PilonTests {

    @Test
    public void test01ConstruyoUnPilonQueEstaraListoEn5Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio pilon = new Pilon(casillero, inventario);

        //ACT
        for(int i=0; i<5; i++){
            pilon.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(pilon.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnPilonQueNoSePuedeUsarPasados4Turnos() {

        //ARRANGE
        String mensaje = "Tu Pilon ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio pilon = new Pilon(casillero, inventario);

        //ACT
        for(int i=0; i<4; i++){
            pilon.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            pilon.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03NoSePuedeConstruirUnAccesoFueraDelRangoDelPilon(){
        //ARRANGE
        String mensaje = "No se puede construir en este tipo de casillero";
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(false);
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04NoSePuedeConstruirUnPuertoEstelarFueraDelRangoDelPilon(){
        //ARRANGE
        String mensaje = "No se puede construir en este tipo de casillero";
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(false);
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test05SePuedeConstruirUnAccesoDentroDelRangoDelPilon(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        //ACT
        Acceso acceso = new Acceso(casillero, inventario);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test06SePuedeConstruirUnPuertoEstelarDentroDelRangoDelPilon(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        //ACT
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }
}
