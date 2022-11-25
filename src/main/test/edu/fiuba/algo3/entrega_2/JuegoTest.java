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
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0, jugador1);
        //ASSERT
        assertDoesNotThrow(() -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1, jugador2));
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
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0, jugador1);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1, jugador2));
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
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0, jugador1);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1,jugador2));
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
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        //ACT
        juego.registrarJugador(nombreJugador1, colorJugador1, razaJugador1, 0, jugador1);
        //ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador2, colorJugador2, razaJugador2, 1,jugador2));
    }

    @Test
    public void test05NoSePuedeRegistrarNombreCorto() {
        //ARRANGE
        Juego juego = new Juego();
        String nombreJugador = "Jug";
        String colorJugador = "Rojo";
        String razaJugador = "Protoss";
        Jugador jugador1 = new Jugador();
        //ACT & ASSERT
        assertThrows(ParametrosInvalidos.class, () -> juego.registrarJugador(nombreJugador, colorJugador, razaJugador, 0,jugador1));
    }

    @Test
    public void Test06SeCreanLosVolcanesEnLasPosicionesCorrespondientes(){

        //Arrange
        int alto = 50;
        int ancho = 50;
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        juego.registrarJugador("Nombre1", "Violeta", "Zerg", 0,jugador1);
        juego.registrarJugador("Nombre2", "Azul", "Protoss", 1,jugador2);
        Mapa mapa = new Mapa(alto,ancho);

        //Act
        juego.crearBases(mapa);

        //Assert
        assertTrue(mapa.obtenerCasillero(0,0).esDelTipo(new NodoGas()));
        assertTrue(mapa.obtenerCasillero(ancho-1,alto-1).esDelTipo(new NodoGas()));
    }

    @Test
    public  void Test07SeCreanLosMineralesEnLasPosicionesCorrespondientes(){
        //Arrange
        int alto = 50;
        int ancho = 50;
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        juego.registrarJugador("Nombre1", "Violeta", "Zerg", 0,jugador1);
        juego.registrarJugador("Nombre2", "Azul", "Protoss", 1,jugador2);
        Mapa mapa = new Mapa(alto,ancho);

        //Act
        juego.crearBases(mapa);

        //Assert
        //Extremo 1
        assertTrue(mapa.obtenerCasillero(0,1).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(0,2).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(1,1).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(1,0).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(2,0).esDelTipo(new NodoMineral()));
        //Extremo2
        assertTrue(mapa.obtenerCasillero(49,47).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(49,48).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(48,48).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(48,49).esDelTipo(new NodoMineral()));
        assertTrue(mapa.obtenerCasillero(47,49).esDelTipo(new NodoMineral()));
    }


}
