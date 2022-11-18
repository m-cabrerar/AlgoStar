package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.exceptions.RecursoAgotado;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class casosDeUso7 {
    /*Verificar la recolección de minerales para ambas razas.*/

    @Test
    public void Test01NodoMineraAgotadolLanzaErrorCuandoIntentanExtraerMineral() throws Exception {
        //ARRANGE
        String mensajeError = "Nodo Mineral Agotado, no es posible extraer";

        NodoMineral unNodoMineral = new NodoMineral();
        unNodoMineral.extraerMineral(2000);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            unNodoMineral.extraerMineral(10);
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
    }

    @Test
    public void Test02NodoMineralRestante20Extraen20MineralNoDebeLanzarExcepcion() throws Exception {
        //ARRANGE
        NodoMineral unNonoMineral = new NodoMineral();
        unNonoMineral.extraerMineral(1980);
        //ACT
        try {
            unNonoMineral.extraerMineral(20);
        } catch(Exception e) {
            fail("Should not have thrown any exception");
        }
    }
    @Test
    public void Test03ProtossIntentaRecolectarCuandoNodoMinealVacioLanzaExcepcion() throws Exception {
        //ARRANGE
        String mensajeError = "Nodo Mineral Agotado, no es posible extraer";
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.extraerMineral(anyInt())).thenThrow(new RecursoAgotado("Nodo Mineral Agotado, no es posible extraer"));
        NexoMineral nexoMineral = new NexoMineral(casilleroMock, inventarioMock);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            nexoMineral.pasarTurno();
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
    }

    @Test
    public void Test04NodoGasAgotadoLanzaExcepcionCuandoIntentanExtraer(){
        String mensajeError = "Nodo Gas Agotado, no es posible extraer";

        NodoGas unNodoGas = new NodoGas();
        unNodoGas.extraerGas(5000);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            unNodoGas.extraerGas(20);
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
    }

    @Test
    public void Test05NodoGasRestante20Extraen20GasNoDebeLanzarExcepcion() throws Exception {
        //ARRANGE
        NodoGas unNodoGas = new NodoGas();
        unNodoGas.extraerMineral(4980);
        //ACT
        try {
            unNodoGas.extraerMineral(20);
        } catch(Exception e) {
            fail("Should not have thrown any exception");
        }
    }
    @Test
    public void Test06ProtossIntentaRecolectarGasCuandoNodoGasVacioLanzaExcepcion() throws Exception {
        //ARRANGE
        String mensajeError = "Nodo Gas Agotado, no es posible extraer";
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.extraerGas(anyInt())).thenThrow(new RecursoAgotado("Nodo Gas Agotado, no es posible extraer"));
        Asimilador asimilador = new Asimilador(casilleroMock, inventarioMock);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            asimilador.pasarTurno();
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
    }

    @Test //prueba de integracion, necesito Mapa
    public void Test07InventarioTieneRescursosDespuesDeQueNexoExtraigaMineral() throws Exception {
        //ARRANGE
        Mapa mockedMap = mock(Mapa.class);
        Casillero unCasillero = new Casillero(1,1,mockedMap);
        NodoMineral mockedNodoMineral = mock(NodoMineral.class);
        unCasillero.setTipoCasillero(mockedNodoMineral);
        when(mockedNodoMineral.extraerMineral(anyInt())).thenReturn(20);
        Inventario inventario = new Inventario();
        NexoMineral unNexoMineral = new NexoMineral(unCasillero, inventario);
        //ACT
        unNexoMineral.pasarTurno();
        //ASSERT
        assertTrue(inventario.tieneRecursos(20,0));
    }


    @Test
    public void Test04ZergNoPuedeExtraerMineralSinEngendrarZangano(){
        //ARRENGE
        String mensajeError = "No hay zanganos disponibles para extraer Mineral";
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
;        Criadero unCriadero = new Criadero(mockedCasillero, mockedInventario);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            unCriadero.enviarZanganoExtraerMineral();
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());

    }

}





