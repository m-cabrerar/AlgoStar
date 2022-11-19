package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class casosDeUso7 {
    /*Verificar la recolección de minerales para ambas razas.*/

    @Test
    public void Test01NodoMineraAgotadoNoExtraeCuandoIntentanExtraerMineral(){
        //ARRANGE
        NodoMineral unNodoMineral = new NodoMineral();
        unNodoMineral.extraerMineral(2000);
        int mineralEsperado=0;
        //ACT
        int mineralExtraido = unNodoMineral.extraerMineral(10);

        //ASSERT
        assertEquals(mineralExtraido, mineralEsperado);
    }

    @Test
    public void Test02NodoMineralRestante20Extraen20MineralDevuelveLoQueExtrajo() throws Exception {
        //ARRANGE
        NodoMineral unNodoMineral = new NodoMineral();
        unNodoMineral.extraerMineral(1980);
        int mineralEsperado=20;
        //ACT
        int mineralExtraido = unNodoMineral.extraerMineral(20);
        //ASSERT
        assertEquals(mineralExtraido, mineralEsperado);
    }

    @Test
    public void Test03ProtossIntentaRecolectarCuandoNodoMinealVacioNoSumaNada() throws Exception {
        //ARRANGE
        String mensajeError = "Nodo Mineral Agotado, no es posible extraer";
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        NexoMineral nexoMineral = new NexoMineral(casilleroMock, inventarioMock);
        int mineralEsperado = 0;
        //ACT
        int mineralExtraido = nexoMineral.extraerMineral(0);

        //ASSERT
        assertEquals(mineralExtraido, mineralEsperado);
    }

    @Test
    public void Test04NodoGasAgotadoNoExtraeNada(){
        //ARRANGE
        NodoGas unNodoGas = new NodoGas();
        unNodoGas.extraerGas(5000);
        int gasEsperado=0;
        //ACT
        int gasExtraido = unNodoGas.extraerGas(20);
        //ASSERT
        assertEquals(gasEsperado, gasExtraido);
    }

    @Test
    public void Test05NodoGasRestante20Extraen20GasDevuelveLoQueExtrajo() throws Exception {
        //ARRANGE
        NodoGas unNodoGas = new NodoGas();
        unNodoGas.extraerGas(4980);
        int gasEsperado = 20;
        //ACT
        int gasExtraido = unNodoGas.extraerGas(20);
        //ASSERt
        assertEquals(gasEsperado, gasExtraido);

    }

    @Test
    public void Test06ProtossIntentaRecolectarGasCuandoNodoGasVacioNoExtrae(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        Casillero casilleroMock = mock(Casillero.class);
        Asimilador asimilador = new Asimilador(casilleroMock, inventarioMock);
        int gasEsperado =0;
        //ACT
        int gasExtraido = asimilador.extraerGas();
        //ASSERT
        assertEquals(gasEsperado, gasExtraido);
    }

    /*
    @Test //prueba de mas integral, mockeo Mapa
    public void Test07InventarioTieneRescursosAlAgregarMineral() throws Exception {
        //ARRANGE
        Mapa mockedMap = mock(Mapa.class);
        Casillero unCasillero = new Casillero(1,1,mockedMap);
        NodoMineral mockedNodoMineral = mock(NodoMineral.class);
        unCasillero.setTipoCasillero(mockedNodoMineral);
        when(mockedNodoMineral.extraerMineral(anyInt())).thenReturn(20);

        Inventario inventario = new Inventario();
        NexoMineral unNexoMineral = new NexoMineral(unCasillero, inventario);
        inventario.agregarNexo(unNexoMineral);
        //ACT
        inventario.agregarMineral();
        //ASSERT
        assertTrue(inventario.tieneRecursos(20,0));
    }

*/
    @Test
    public void Test04ZergNoPuedeExtraerMineralSinEngendrarZangano(){
        //ARRENGE
        String mensajeError = "No hay zanganos disponibles para extraer Mineral";
        Casillero mockedCasillero = mock(Casillero.class);
        Inventario mockedInventario = mock(Inventario.class);
        ;        Criadero unCriadero = new Criadero(mockedCasillero, mockedInventario);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            unCriadero.enviarZanganoExtraerMineral(0);
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());

    }


}


