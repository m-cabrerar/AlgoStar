package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.TipoCasillero;

import java.util.*;

public class Mapa {
    public int anchoMapa;
    public int altoMapa;
    private List<List<Casillero>> tableroActual;
    private int tiempoVida;
    public Mapa( int alto, int ancho){
        this.anchoMapa = ancho;
        this.altoMapa = alto;
        List<List<Casillero>> tablero = new ArrayList<>();
        for (int i = 0; i < ancho; i++)  {
            tablero.add(new ArrayList<>());
            for (int j = 0; j < alto; j++) {
                tablero.get(i).add(new Casillero(i,j,this));
            }
        }
        this.tableroActual = tablero;
        this.tiempoVida = 1;
    }

    public void cambiarTipoCasilla(int x, int y, TipoCasillero tipoCasillero){
        obtenerCasillero(x,y).setTipoCasillero(tipoCasillero);
    }

    public List<Casillero> CasillerosAdyacentes(int x,int y){
        if (!this.enRango(x,y)){
            return null;
        }
        List<Casillero> adyacentes = new ArrayList<>();
        if (this.enRango(x-1,y)){adyacentes.add(obtenerCasillero(x-1,y));}
        if (this.enRango(x+1,y)){adyacentes.add(obtenerCasillero(x+1,y));}
        if (this.enRango(x,y-1)){adyacentes.add(obtenerCasillero(x,y-1));}
        if (this.enRango(x,y+1)){adyacentes.add(obtenerCasillero(x,y+1));}
        return adyacentes;
    }
    public List<Casillero> casillerosEnRango(int xInicial,int yInicial, int rango){
        List<Casillero> casillerosEnRango = new ArrayList<>();
        casillerosEnRango.add(obtenerCasillero(xInicial,yInicial));

        for (int i = 0; i < rango; i++) {
            for (ListIterator<Casillero> casilleros = casillerosEnRango.listIterator(); casilleros.hasNext();) {
                Casillero casillero = casilleros.next();
                int x = casillero.posicionX();
                int y = casillero.posicionY();
                if (this.enRango(x-1,y) && !casillerosEnRango.contains(obtenerCasillero(x-1,y))){
                    casilleros.add(obtenerCasillero(x-1,y));}

                if (this.enRango(x+1,y) && !casillerosEnRango.contains(obtenerCasillero(x+1,y))){
                    casilleros.add(obtenerCasillero(x+1,y));}

                if (this.enRango(x,y-1) && !casillerosEnRango.contains(obtenerCasillero(x,y-1))){
                    casilleros.add(obtenerCasillero(x,y-1));}

                if (this.enRango(x,y+1) && !casillerosEnRango.contains(obtenerCasillero(x, y+1))){
                    casilleros.add(obtenerCasillero(x,y+1));}
            }
        }
        return casillerosEnRango;
    }

    public boolean enRango(int x, int y){
        ///Devuelve true si no se exceden las medidas del mapa
        return ((0 <= x) && (x < this.anchoMapa)) && ((0 <= y) && (y < this.altoMapa));
    }
    public void pasarTurno(){
        this.tiempoVida += 1;
        System.out.println("turno: " + this.tiempoVida);
        //Solo se puede expandir moho cada dos turnos
        if(this.tiempoVida % 2 == 0){
            for (List<Casillero> listaCasilleros : this.tableroActual){
                for (Casillero casillero : listaCasilleros){
                    casillero.pasarTurno();
                }
            }
        }
    }

    public void energizar(int x, int y ,int rango) {
        List<Casillero> casillerosEnRango = casillerosEnRango(x, y, rango);
        for(Casillero casillero : casillerosEnRango) {
            casillero.energizar();
        }
    }
    public void desenergizar(int x, int y ,int rango){
        List<Casillero> casillerosEnRango = casillerosEnRango(x,y,rango);
        for (Casillero casillero : casillerosEnRango) {
            casillero.desenergizar();
        }
    }
    public List<List<Integer>> equidistantesPares(int cantidad){
        //int[][] posiciones = {{0,0},{this.anchoMapa-1,this.altoMapa-1}};
        List<List<Integer>> posiciones = new ArrayList<>();
        posiciones.add(new ArrayList<>());
        posiciones.add(new ArrayList<>());
        posiciones.get(0).add(0);
        posiciones.get(0).add(0);
        posiciones.get(1).add(this.anchoMapa-1);
        posiciones.get(1).add(this.altoMapa-1);

        int ultima_pos = 1;
        int pos1X= 0;
        int pos2X = this.anchoMapa - 1;
        int equidistantes = (cantidad/2 - 1);
        for (int i = 0; i < equidistantes; i++) {
            //Calculo un equidistante para la primera fila:
            pos1X += ((this.anchoMapa-1)/ equidistantes);
            posiciones.add(new ArrayList<>());
            posiciones.get(ultima_pos+1).add(pos1X);
            posiciones.get(ultima_pos+1).add(0);

            //Calculo un equidistante  para la ultima fila:
            pos2X -= ((this.anchoMapa-1) / equidistantes);
            posiciones.add(new ArrayList<>());
            posiciones.get(ultima_pos+2).add(pos2X);
            posiciones.get(ultima_pos+2).add(this.altoMapa - 1);
            ultima_pos += 2;
        }
        return posiciones;
    }

    public Casillero obtenerCasillero(int x, int y){
        return this.tableroActual.get(x).get(y);
    }
    public int getAlto(){
        return this.altoMapa;
    }
    public int getAncho(){
        return this.anchoMapa;
    }
}
