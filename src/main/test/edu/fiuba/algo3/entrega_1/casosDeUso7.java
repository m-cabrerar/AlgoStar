package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class casosDeUso7 {
    //*Verificar la recolección de minerales para ambas razas.*//*
    //ARRANGE
    /*
    @Test
    public void Test01ProtossIntentaRecolectarCuandoNodoMinealVacio(){
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario();
        inventario.agregarGas(50);
        NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        //Dejo el inventario en 0
        inventario.pagarMateriales(0,200);

        //ACT - Vacio Nodo y extraigo una vez mas
        for (int i = 0; i < 100; i++) {
            nexoMineral.extraerMineral(inventario);
        }
        nexoMineral.extraerMineral(inventario);

        //ASSERT - Solo recolecte la capacidad maxima del mineral
            assertTrue(inventario.tieneRecursos(0,2000));
            assertFalse(inventario.tieneRecursos(0,2001));
    }

    @Test
    public void Test02ProtossNexoMineralRecolecta10mineralEnUnTurno(){
        //*se asume que se recolecta 10 mineral por turno. Después se corroborará*//*
        //Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario();
        NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        assertTrue(inventario.tieneRecursos(0,200));
        //Dejo el inventario en 0


        //ACT


        //ASSERT


    }


    @Test
    public void Test03ProtossNoPuedeExtraerMineralSinEngendrarZangano(){

        //ARRANGE
        String mensaje = "No hay zanganos disponibles";

        //ARRANGE
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casillero,mockedInventario);

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.enviarZanganoAExtraerMineral();
        });
        assertEquals(mensaje, exception.getMessage());
    }


    @Test
    public void Test04ZergZanganoExtrae10mineralEnUnTurno(){

        //ARRANGE
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        Criadero criadero = new Criadero(casillero,mockedInventario);
        criadero.engendrarZangano();

        //ACT
        for(int i=0; i<6; i++){
            criadero.pasarTurno();
        }
        Mineral mineralObtenido = criadero.enviarZanganoAExtraerMineral();

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total());
    }
 */
}
