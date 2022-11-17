package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

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
}
