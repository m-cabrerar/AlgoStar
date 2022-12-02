package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.*;
public class EdificioZergTests {

    // Asumo que los edificios Zerg recuperan 10 de vida por turno.

    @Test
    public void test01CriaderoRecibeDanioYRecuperaVida() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Danio danio = new Danio(0,490);
        Danio danio2 = new Danio(0,10);
        
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        try {
            criadero.recibirDanio(danio);
            criadero.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> criadero.recibirDanio(danio2));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test02ExtractorRecibeDanioYRecuperaVida() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Extractor extractor = new Extractor(casilleroMock, inventarioMock);
        Danio danio = new Danio(0,740);
        Danio danio2 = new Danio(0,10);
        //ACT
        try {
            extractor.recibirDanio(danio);
            extractor.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> extractor.recibirDanio(danio2));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test03ReservaDeReproduccionRecibeDanioYRecuperaVida() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(casilleroMock, inventarioMock);
        Danio danio = new Danio(0,990);
        Danio danio2 = new Danio(0,10);
        //ACT
        try {
            reserva.recibirDanio(danio);
            reserva.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> reserva.recibirDanio(danio2));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test04GuaridaRecibeDanioYRecuperaVida() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Guarida guarida = new Guarida(casilleroMock, inventarioMock);
        Danio danio = new Danio(0,1240);
        Danio danio2 = new Danio(0,10);
        //ACT
        try {
            guarida.recibirDanio(danio);
            guarida.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> guarida.recibirDanio(danio2));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test05EspiralRecibeDanioYRecuperaVida() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);
        Espiral espiral = new Espiral(casilleroMock, inventarioMock);
        Danio danio = new Danio(0, 1290);
        Danio danio2 = new Danio(0,10);
        //ACT
        try {
            espiral.recibirDanio(danio);
            espiral.pasarTurno();
            //ASSERT
            assertDoesNotThrow(() -> espiral.recibirDanio(danio2));
        } catch (Exception e) {
            fail();
        }
    }
}
