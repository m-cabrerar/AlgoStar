package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.unidades.edificios.Acceso;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CriaderoTests {
    /*Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 y
     *después de 1 turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar
     *que se regeneren acorde a los tiempos estipulados.
     */
    @Test
    public void test01ConsumoLaLarvaDeUnCriaderoParaEngendrarZanganoYCuandoPasaElTurnoTengo3OtraVez() {
        
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casillero = mock(Casillero.class);
        Inventario inventario =new Inventario();
        inventario.agregarGas(200);

        Criadero criadero = new Criadero(casillero, inventario);
        //ACT
        try {
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
 
    }

    @Test
    public void test02Consumo2LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan2TurnosTengo3OtraVez() {
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casillero = mock(Casillero.class);
        Inventario inventario =new Inventario();
        inventario.agregarGas(200);
        Criadero criadero = new Criadero(casillero, inventario);
        //ACT
        try {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test03Consumo3LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan3TurnosTengo3OtraVez() {
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario =new Inventario();
        inventario.agregarGas(200);
        Criadero criadero = new Criadero(casilleroMock, inventario);
        //ACT
        try {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        } catch (Exception e) {
            fail();
        }
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04ConstruyoUnCriaderoQueEstaraListoEn4Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario =new Inventario();
        inventario.agregarGas(200);
        Danio danio = new Danio(0,5);
        Criadero criadero = new Criadero(casilleroMock, inventario);

        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        //ASSERT
        assertDoesNotThrow(() -> criadero.recibirDanio(danio));

    }
    @Test
    public void test05ConstruyoUnCriaderoQueNoSePuedeUsarPasados3Turnos() {
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventarioMock = mock(Inventario.class);

        Danio danio = new Danio(0,5);

        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.puedeConstruir(anyInt())).thenReturn(true);

        try {
            Unidad criadero = Criadero.construir(casilleroMock, inventarioMock);
            //ACT
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.pasarTurno();
            criadero.recibirDanio(danio);
            //ASSERT
            assertThrows(EstaDestruido.class, () -> criadero.recibirDanio(danio));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void test06ConstruirUnCriaderoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "Ubicacion invalida";
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario inventario =new Inventario();
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test07NoPuedoConstruirUnCriaderoSinLosRecursos(){
        //ARRANGE
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario =new Inventario();
        inventario.pagarMateriales(0,200);
        //ACT & ASSERT
        assertThrows(RecursosInsuficientes.class, () -> Criadero.construir(casilleroMock, inventario));
    }

    @Test
    public void test08ConstruirUnCriaderoSobreCasillaVaciaNoError(){
        //ARRANGE
        String mensaje = "Ubicacion invalida";
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario inventario =new Inventario();
        //ACT & ASSERT
        assertDoesNotThrow(() -> Criadero.construir(casillero, inventario));    }
}