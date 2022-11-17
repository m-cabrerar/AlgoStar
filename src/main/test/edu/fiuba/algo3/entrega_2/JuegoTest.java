package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    @Test
    public void test01JuegoSeCreaConDosJugadores() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador1 = "Jugador 1";
        String nombreJugador2 = "Jugador 2";
        String colorJugador1 = "Rojo";
        String colorJugador2 = "Azul";
        String razaJugador1 = "Protoss";
        String razaJugador2 = "Zerg";
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0);
        //ASSERT
        assertDoesNotThrow(() -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1));
    }

    @Test
    public void test02NoSePuedeRepetirNombre() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador1 = "Jugador 1";
        String nombreJugador2 = "Jugador 1";
        String colorJugador1 = "Rojo";
        String colorJugador2 = "Azul";
        String razaJugador1 = "Protoss";
        String razaJugador2 = "Zerg";
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1));
    }

    @Test
    public void test03NoSePuedeRepetirColor() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador1 = "Jugador 1";
        String nombreJugador2 = "Jugador 2";
        String colorJugador1 = "Rojo";
        String colorJugador2 = "Rojo";
        String razaJugador1 = "Protoss";
        String razaJugador2 = "Zerg";
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1));
    }

    @Test
    public void test04NoSePuedeRepetirRaza() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador1 = "Jugador 1";
        String nombreJugador2 = "Jugador 2";
        String colorJugador1 = "Rojo";
        String colorJugador2 = "Azul";
        String razaJugador1 = "Protoss";
        String razaJugador2 = "Protoss";
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1));
    }

    @Test
    public void test05NoSePuedeRegistrarNombreCorto() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador = "Jug";
        String colorJugador = "Rojo";
        String razaJugador = "Protoss";
        //ACT & ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador, colorJugador, razaJugador, 0));
    }

}
