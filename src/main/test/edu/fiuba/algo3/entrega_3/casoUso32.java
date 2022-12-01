package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class casoUso32 {
    /* Verificar el fin del Juego.
    Para ganar un jugador debe destruirle todos los edificios al jugador
contrario.
     */

    @Test
    public void Test01CuandoNoEsTurnoCeroYUnJugadorNoTieneEdificiosGanaElOtro(){
        //ARRANGE
        String mensaje = "Ganador Jugador 1 Protoss";

        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        juego.registrarJugador("Jugador 1", "rojo","Protoss", jugador1);
        juego.registrarJugador("Jugador 2","azul","Zerg", jugador2);

        Casillero mockedCasillero = mock(Casillero.class);

        jugador1.construirPilon(mockedCasillero);
        juego.verificar_ganador();
        //ACT
        String ganador = juego.verificar_ganador();
        //ASSERT
        assertEquals(mensaje, ganador);
    }

    /*
    @Test
    public void Test02JugadorConSoloUnPilonSeLoDestruyenGanaElOtro(){
        //ARRANGE
        String mensaje = "Ganador Jugador 2 Zerg";

        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        juego.registrarJugador("Jugador 1", "rojo","Protoss",0,jugador1);
        juego.registrarJugador("Jugador 2","azul","Zerg",1,jugador2);

        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);

        jugador1.construirPilon(mockedCasillero);
        jugador2.construirExtractor(mockedCasillero);
        //pasar el extraer a pasar turno? tendria problemas con la construccion
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        jugador2.crearHidralisco();

        juego.verificar_ganador();
        //ACT
        String ganador = juego.verificar_ganador();
        //ASSERT
        assertEquals(mensaje, ganador);
    }
    
     */
}


