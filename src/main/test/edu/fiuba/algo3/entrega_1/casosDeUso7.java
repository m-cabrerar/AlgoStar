package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class casosDeUso7 {
    /*Verificar la recolección de minerales para ambas razas.*/

    @Test
    public void Test01NodoMineralLanzaErrorCuandoIntentanExtraerMineral() {
        //ARRANGE
        String mensajeError = "Nodo Mineral Agotado, no es posible extraer";
        Inventario inventarioMock = mock(Inventario.class);
        NodoMineral unNodoMineral = new NodoMineral();
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            unNodoMineral.extraerMineral(inventarioMock, 10);
        });
        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
        verify(inventarioMock, never()).recibirMineral(10);

    }

    @Test
    public void Test02ProtossIntentaRecolectarCuandoNodoMinealVacio() {
        //ARRANGE
        String mensajeError = "Nodo Mineral Agotado, no es posible extraer";
        NodoMineral nodoMineralMock = mock(NodoMineral.class);
        Inventario inventarioMock = mock(Inventario.class);
        when(nodoMineralMock.extraerMineral(inventarioMock, 10)).thenThrow(new RuntimeException());
        Casillero casilleroMock = mock(Casillero.class);

        NexoMineral nexoMineral = new NexoMineral(casilleroMock, inventarioMock);

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            nexoMineral.extraerMineral(inventarioMock);
        });

        //ASSERT
        assertEquals(mensajeError, exception.getMessage());
    }
}
/*
    @Test
    public void Test03ProtossNexoMineralRecolecta10mineralEnUnTurno(){
        /*se asume que se recolecta 10 mineral por turno. Después se corroborará*/
//Arrange
//Mineral mineralEsperado = new Mineral(10);//
       /*
        Casillero mockedNodoMineral = mock(Casillero.class);
        when(mockedNodoMineral.extraerMineral()).thenReturn(true);
        Inventario inventario = new Inventario(50,0);
        Edificio nexoMineral = NexoMineral.construir(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            nexoMineral.pasarTurno();
        }
        nexoMineral.extraerMineral();

        //ASSERT
        assertEquals(inventario.mineral, 10);

        verify(mockedNodoMineral,times(1)).extraerMineral();
    }


    @Test
    public void Test04ProtossNoPuedeExtraerMineralSinEngendrarZangano(){

        //ARRANGE
        String mensaje = "No hay zanganos disponibles";

        //ARRANGE
        Casillero casillero = new NodoMineral();
        Criadero criadero = Criadero.inicializar();

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.enviarZanganoAExtraerMineral();
        });
        assertEquals(mensaje, exception.getMessage());
    }


    @Test
    public void Test05ZergZanganoExtrae10mineralEnUnTurno(){

        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        Mineral mineralEsperado = new Mineral(10)
        Casillero casillero = new NexoMineral();
        //por ahora el criadero se encarga directamente de esta tarea, necesita refactor
        //el haber engendrado zangano es lo que le permite extraerMineral
        criadero.engendrarZangano();

        //ACT
        for(int i=0; i<6; i++){
            criadero.pasarTurno();
        }
        Mineral mineralObtenido = criadero.enviarZanganoAExtraerMineral();

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total());
    }

}

        */
