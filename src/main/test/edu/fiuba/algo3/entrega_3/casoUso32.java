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
    public void Test01JugadorConSoloUnEdificioLoDestruyenElOtroGanaJuego(){
        //ARRANGE
        String mensaje = "Ganador Jugador jug1 Protoss";
        Mapa mapaMock = mock(Mapa.class);
        Juego juego = new Juego();
        juego.registrarJugador("Jugador 1", "rojo","Protoss",0 );
        juego.registrarJugador("Jugador 2","azul","Zerg",1);
       // juego.crearBases(mapaMock);

        juego.verificar_ganador();
        //COMO mockeo el inventario si lo crea el jugador?
        //ACT
        String ganador = juego.verificar_ganador();
        //ASSERT
        assertEquals(mensaje, ganador);
    }

    @Test
    public void Test02(){

    }

}
