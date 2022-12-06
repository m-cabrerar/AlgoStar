package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.NodoGas;
import edu.fiuba.algo3.modelo.casillero.NodoMineral;

import java.util.List;
import java.util.Random;

public class Juego {
    private final Mapa mapa;
    private final int CANTIDAD_DE_JUGADORES = 2;
    private Jugador[] jugadores = new Jugador[CANTIDAD_DE_JUGADORES];
    private int cantidadDeJugadores = 0;

    private int turnos;

    public Juego() {
        this.mapa = new Mapa(30, 30);
        this.turnos = 0;
    }

    public void registrarJugador(String nombre, String color, String raza, Jugador jugador) throws ParametrosInvalidos {
        if (Jugador.nombreValido(nombre, jugadores) && Jugador.colorValido(color, jugadores) && Jugador.razaValida(raza, jugadores)) {
            jugador.setDatos(nombre, color, raza);
            jugadores[cantidadDeJugadores] = jugador;//new Jugador(nombre, color, raza);
            cantidadDeJugadores++;
        } else {
            throw new ParametrosInvalidos("Los parametros ingresados no son validos");
        }
    }

    public void crearTerreno() {
        Random random = new Random();
        //Random en rango: int randomNum = rand.nextInt((max - min) + 1) + min;

        //Casilleros: cuantos de los totales cambian de tipo
        int cantidadCasillasMineral = (mapa.altoMapa)*(mapa.anchoMapa)/30;
        int cantidadCasillasGas = (mapa.altoMapa)*(mapa.anchoMapa)/30;
        int cantidadEspaciales =(mapa.altoMapa)*(mapa.anchoMapa) /40;

        int maximaAltura = mapa.altoMapa - 1;
        int maximoAncho = mapa.anchoMapa -1;

        //ESPACIALES los restrinjo un poco mas para q no esten en zonas de bases.
        for (int i = 0; i < cantidadEspaciales; i++) {
            int anchoRandom = random.nextInt((maximoAncho-4) + 1);
            int altoRandom = random.nextInt((maximaAltura-4 - 4) + 1) + 4;
            if (mapa.enRango(anchoRandom, altoRandom)) {
                mapa.cambiarTipoCasilla(anchoRandom,altoRandom, new CasilleroEspacial());

                //Hago algunos de sus adyacentes espaciales
                for (int j = 0; j < 3; j++) {
                    int valorRandom = random.nextInt(100);
                    List<Casillero> adyacentes = mapa.CasillerosAdyacentes(anchoRandom,altoRandom);
                    int indiceCasillaRandom = random.nextInt(adyacentes.size());
                    if((valorRandom%2) == 0){
                        adyacentes.get(indiceCasillaRandom).setTipoCasillero(new CasilleroEspacial());
                    }
                }
            }
        }
        //Minerales
        for (int i = 0; i < cantidadCasillasMineral; i++) {
            int anchoRandom = random.nextInt((maximoAncho) + 1);
            int altoRandom = random.nextInt((maximaAltura) + 1);
            mapa.cambiarTipoCasilla(anchoRandom,altoRandom, new NodoMineral());
        }

        //Gas
        for (int i = 0; i < cantidadCasillasGas; i++) {
            int anchoRandom = random.nextInt((maximoAncho) + 1);
            int altoRandom = random.nextInt((maximaAltura) + 1);
            mapa.cambiarTipoCasilla(anchoRandom,altoRandom, new NodoGas());
        }

    }

    public void crearBases(int cantBasesPares){
        List<List<Integer>> posiciones = mapa.equidistantesPares(cantBasesPares);
        for (List<Integer> posicion: posiciones) {
            int[] posicionActual = {posicion.get(0), posicion.get(1)};

            //agrego minerales
            List<Casillero> casillerosMineral= mapa.casillerosEnRango(posicionActual[0],posicionActual[1],3);
            for (Casillero casillero : casillerosMineral){
                mapa.cambiarTipoCasilla(casillero.posicionX(), casillero.posicionY(), new NodoMineral());
            }
            //agrego volcanes
            mapa.cambiarTipoCasilla(posicionActual[0],posicionActual[1],new NodoGas());
        }
    }

    public void pasarTurno(){
        for (Jugador jugador : jugadores) {
            jugador.pasarTurno();
        }
    }

    public String verificar_ganador(){ //todo:despues lo hará en pasarTurno
        if(turnos!=0){
            if(!jugadores[0].tieneEdificios()){
                return "Ganador " + jugadores[1].getNombreYRaza();
            }else if(!jugadores[1].tieneEdificios()){
                return "Ganador " + jugadores[0].getNombreYRaza();
            }
        }
        turnos ++; //esto tampoco se hará aca
        return null;
    }

    public int cantidadDeJugadores(){
        return cantidadDeJugadores;
    }
    public int cantidadDeJugadoresMaxima(){
        return CANTIDAD_DE_JUGADORES;
    }
    public Mapa getMapa(){
        return mapa;
    }
    public Inventario[] getInventarios(){
        Inventario[] inventarios = new Inventario[CANTIDAD_DE_JUGADORES];
        for (int i = 0; i < CANTIDAD_DE_JUGADORES; i++) {
            inventarios[i] = jugadores[i].getInventario();
        }
        return inventarios;
    }
    public Jugador[] getJugadores(){
        return jugadores;
    }
    public int getTurnos(){
        return turnos;
    }
}
