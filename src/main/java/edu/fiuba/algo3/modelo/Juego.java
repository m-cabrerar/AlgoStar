package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

import java.util.List;

public class Juego {
    private final int CANTIDAD_DE_JUGADORES = 2;
    private Jugador[] jugadores = new Jugador[CANTIDAD_DE_JUGADORES];

    public void registrarJugador(String nombre, String color, String raza, int n) throws ParametrosInvalidos {
        if (Jugador.nombreValido(nombre, jugadores) && Jugador.colorValido(color, jugadores) && Jugador.razaValida(raza, jugadores)){
            jugadores[n] = new Jugador(nombre, color, raza);
        }
        else {
            throw new ParametrosInvalidos("Los parametros ingresados no son validos");
        }
    }

    public void crearBases(Mapa mapa){
        int[][] posiciones = mapa.posicionesExtremo();
        int[] posicion1 = posiciones[0];
        int[] posicion2 = posiciones[1];

        //agrego minerales
        List<Casillero> casillerosMineral= mapa.casillerosEnRango(posicion1[0],posicion1[1],2);
        for (Casillero casillero : casillerosMineral){
            mapa.cambiarTipoCasilla(casillero.posicionX(), casillero.posicionY(), new NodoMineral());
        }

        List<Casillero> casillerosMineral2= mapa.casillerosEnRango(posicion2[0],posicion2[1],2);
        for (Casillero casillero : casillerosMineral2){
            mapa.cambiarTipoCasilla(casillero.posicionX(), casillero.posicionY(), new NodoMineral());
        }
        //agrego volcanes
        mapa.cambiarTipoCasilla(posicion1[0],posicion1[1],new NodoGas());
        mapa.cambiarTipoCasilla(posicion2[0],posicion2[1],new NodoGas());
    }
}