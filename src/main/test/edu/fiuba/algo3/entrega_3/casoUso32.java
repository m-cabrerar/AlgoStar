package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import org.junit.jupiter.api.Test;

public class casoUso32 {
/*
     Verificar el fin del Juego.
    Para ganar un jugador debe destruirle todos los edificios al jugador
contrario.
*/

    @Test
    public void Test01CuandoNoEsTurnoCeroYUnJugadorNoTieneEdificiosGanaElOtro() {
        //ARRANGE
        Juego juego = new Juego();

        juego.registrarJugador("Jugador 1", "rojo", "Protoss");
        juego.registrarJugador("Jugador 2", "azul", "Zerg");

        Jugador jugador1 =  juego.getJugadores()[0];

        Casillero mockedCasillero = mock(Casillero.class);

        Pilon.construir(mockedCasillero, jugador1.getInventario());
        juego.pasarTurno();
        juego.juegoTerminado();
        //ACT
        Jugador ganador = juego.getGanador();
        //ASSERT
        assertEquals(ganador, jugador1);
    }
}


