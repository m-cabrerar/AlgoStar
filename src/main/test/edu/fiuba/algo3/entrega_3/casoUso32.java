package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

public class casoUso32 {
    /* Verificar el fin del Juego.
    Para ganar un jugador debe destruirle todos los edificios al jugador
contrario.
     */

    @Test
    public void Test01JugadorConSoloUnPilonLoDestruyenElOtroGanaJuego(){
        //ARRANGE
        String mensaje = "Ganador Jugador jug1 Protoss"
        Mapa mapaMock = mock(Mapa.class);
        Juego juego = new Juego();
        juego.registrarJugador("jug1", "rojo","Protoss",1 );
        juego.registrarJugador("jug2","azul","Protoss",2);
        juego.crearBases(mapaMock);
        //ACT
        String ganador = juego.verificar_ganador();
        //ASSERT
        assertEquals(mensaje, ganador);
    }

    @Test
    public void Test02(){

    }

}
