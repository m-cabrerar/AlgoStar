package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso24 {
    //Verificar que cada jugador comienza en una base en extremos opuestos del mapa.

    @Test
    public void Test01SeCreanLosVolcanesEnLasPosicionesCorrespondientes(){

        //Arrange
        int alto = 50;
        int ancho = 50;
        Juego juego = new Juego();
        juego.registrarJugador("Nombre1", "Violeta", "Zerg", 0);
        juego.registrarJugador("Nombre2", "Azul", "Protoss", 1);
        Mapa mapa = new Mapa(alto,ancho);

        //Act
        juego.crearBases(mapa);

        //Assert
        assertTrue(mapa.obtenerCasillero(0,0).esDelTipo(new NodoGas()));
        assertTrue(mapa.obtenerCasillero(ancho-1,alto-1).esDelTipo(new NodoGas()));
    }
    @Test
    public  void Test02SeCreanLosMineralesEnLasPosicionesCorrespondientes(){
        //Arrange
        int alto = 50;
        int ancho = 50;
        Juego juego = new Juego();
        juego.registrarJugador("Nombre1", "Violeta", "Zerg", 0);
        juego.registrarJugador("Nombre2", "Azul", "Protoss", 1);
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
