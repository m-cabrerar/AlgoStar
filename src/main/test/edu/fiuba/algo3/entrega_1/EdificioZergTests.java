package edu.fiuba.algo3.entrega_1;
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
        Criadero criadero = new Criadero(casilleroMock, inventarioMock);
        //ACT
        try {
            criadero.recibirDanio(10);
            criadero.pasarTurno();
            //ASSERT
            criadero.recibirDanio(490);
            assertDoesNotThrow(() -> criadero.recibirDanio(10));
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
        //ACT
        try {
            extractor.recibirDanio(10);
            extractor.pasarTurno();
            //ASSERT
            for (int i = 0; i < 74; i++) {
                extractor.recibirDanio(10);
            }
            assertDoesNotThrow(() -> extractor.recibirDanio(10));
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
        //ACT
        try {
            reserva.recibirDanio(10);
            reserva.pasarTurno();
            //ASSERT
            for (int i = 0; i < 99; i++) {
                reserva.recibirDanio(10);
            }
            assertDoesNotThrow(() -> reserva.recibirDanio(10));
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
        //ACT
        try {
            guarida.recibirDanio(10);
            guarida.pasarTurno();
            //ASSERT
            for (int i = 0; i < 124; i++) {
                guarida.recibirDanio(10);
            }
            assertDoesNotThrow(() -> guarida.recibirDanio(10));
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
        //ACT
        try {
            espiral.recibirDanio(10);
            espiral.pasarTurno();
            //ASSERT
            for (int i = 0; i < 129; i++) {
                espiral.recibirDanio(10);
            }
            assertDoesNotThrow(() -> espiral.recibirDanio(10));
        } catch (Exception e) {
            fail();
        }
    }
}
